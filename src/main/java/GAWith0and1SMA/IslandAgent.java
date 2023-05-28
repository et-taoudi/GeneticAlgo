package GAWith0and1SMA;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.SequentialBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class IslandAgent extends Agent {
    private Individual[] population = new Individual[GAUtils.POPULATION_SIZE];
    private Individual individual1;
    private Individual individual2;

    @Override
    protected void setup() {

        SequentialBehaviour sequentialBehaviour=new SequentialBehaviour();
        sequentialBehaviour.addSubBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                initializePopulation();
                sortPopulation();
            }
        });

        sequentialBehaviour.addSubBehaviour(new Behaviour() {
            int iter=0;
            @Override
            public void action() {
                crossover();
                mutation();
                sortPopulation();
                iter++;
            }

            @Override
            public boolean done() {
                return GAUtils.MAX_ITERATIONS == iter || getBestFitnessValue() == GAUtils.CHROMOSOME_SIZE;
            }
        });
        sequentialBehaviour.addSubBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                DFAgentDescription dfAgentDescription=new DFAgentDescription();
                ServiceDescription serviceDescription=new ServiceDescription();
                serviceDescription.setType("ga");
                dfAgentDescription.addServices(serviceDescription);
                DFAgentDescription[] dfAgentDescriptions=null;
                try {
                   dfAgentDescriptions=DFService.search(getAgent(),dfAgentDescription);
                } catch (FIPAException e) {
                    e.printStackTrace();
                }
                ACLMessage aclMessage=new ACLMessage(ACLMessage.INFORM);
                aclMessage.addReceiver(dfAgentDescriptions[0].getName());
                aclMessage.setContent(Arrays.toString(population[0].getChromosome())+" "+String.valueOf(population[0].getFitness()));
                send(aclMessage);

            }
        });
        addBehaviour(sequentialBehaviour);
    }

    public void initializePopulation() {
        for (int i = 0; i < GAUtils.POPULATION_SIZE; i++) {
            population[i] = new Individual();
            population[i].calculateFitness();
        }
    }

    public void crossover() {
        //  selection();
        individual1 = new Individual(Arrays.copyOf(population[0].getChromosome(), GAUtils.CHROMOSOME_SIZE));
        individual2 = new Individual(Arrays.copyOf(population[1].getChromosome(), GAUtils.CHROMOSOME_SIZE));

        Random random = new Random();
        int crossPoint = random.nextInt(GAUtils.CHROMOSOME_SIZE - 1);
        crossPoint++;
        for (int i = 0; i < crossPoint; i++) {
            individual1.getChromosome()[i] = population[1].getChromosome()[i];
            individual2.getChromosome()[i] = population[0].getChromosome()[i];
        }


//        System.out.println("Crossover Point : " + crossPoint);
//        System.out.println("GAWith0and1.sma.Individual 1 : " + Arrays.toString(individual1.getChromosome()));
//        System.out.println("GAWith0and1.sma.Individual 2 : " + Arrays.toString(individual2.getChromosome()));
    }

    public void showPopulation() {
        for (Individual i : population) {
            System.out.println(Arrays.toString(i.getChromosome()) + " = " + i.getFitness());
        }
    }

    public void sortPopulation() {
        Arrays.sort(population, Comparator.reverseOrder());
    }

    public void mutation() {
        Random random = new Random();
        //GAWith0and1.sma.Individual 1
        if (random.nextDouble() > GAUtils.MUTATION_PROBABILITY) {
            int AlphIndex = random.nextInt(GAUtils.ALPHABETICS.length());
            int ChromIndex = random.nextInt(GAUtils.CHROMOSOME_SIZE);
            individual1.getChromosome()[ChromIndex]=GAUtils.ALPHABETICS.charAt(AlphIndex);
        }
        //GAWith0and1.sma.Individual 2
        if (random.nextDouble() > GAUtils.MUTATION_PROBABILITY) {
            int AlphIndex = random.nextInt(GAUtils.ALPHABETICS.length());
            int ChromIndex = random.nextInt(GAUtils.CHROMOSOME_SIZE);
            individual2.getChromosome()[ChromIndex]=GAUtils.ALPHABETICS.charAt(AlphIndex);

        }


//        System.out.println("After Mutation : ");
//        System.out.println("GAWith0and1.sma.Individual 1 : " + Arrays.toString(individual1.getChromosome()));
//        System.out.println("GAWith0and1.sma.Individual 2 : " + Arrays.toString(individual2.getChromosome()));
        individual1.calculateFitness();
        individual2.calculateFitness();
        population[GAUtils.POPULATION_SIZE - 2] = individual1;
        population[GAUtils.POPULATION_SIZE - 1] = individual2;

    }

    public int getBestFitnessValue() {
        return population[0].getFitness();
    }

    @Override
    protected void takeDown() {
        try {
            DFService.deregister(this);
        } catch (FIPAException e) {
            e.printStackTrace();
        }
    }
}
