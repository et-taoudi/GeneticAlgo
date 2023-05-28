package GAWith0and1SMA;

import java.util.Random;

public class Individual implements Comparable {
    private char [] chromosome = new char [GAUtils.CHROMOSOME_SIZE];
    private int fitness ;

    public Individual() {
        Random random=new Random();
        for (int i = 0; i < GAUtils.CHROMOSOME_SIZE; i++) {
            int index=random.nextInt(GAUtils.ALPHABETICS.length());
            chromosome[i]=GAUtils.ALPHABETICS.charAt(index);
        }
    }

    public Individual(char[] chromosome) {
        this.chromosome = chromosome;
    }

    public void calculateFitness() {
        fitness=0;
        for(int i = 0; i < GAUtils.CHROMOSOME_SIZE;i++){
            if(chromosome[i] == GAUtils.TARGET_SOLUTION.charAt(i)){
                fitness++;
            }
        }
    }

    public int getFitness() {
        return fitness;
    }

    public char[] getChromosome() {
        return chromosome;
    }

    @Override
    public int compareTo(Object o) {
        Individual individual=(Individual) o ;
        return Integer.compare(this.fitness, individual.fitness);
    }

    public void setChromosome(char[] chromosome) {
        this.chromosome = chromosome;
    }

    public void setFitness(int fitness) {
        this.fitness = fitness;
    }
}
