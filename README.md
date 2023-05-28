# Genetic Algorithm
## Genetic Algorithm Structure
A Genetic Algorithm is an evolutive process that maintains a population of chromosomes (potential solutions). Each chromosome is composed of several characteristics called genes. The all process has 5 main steps:
1- Initial population generation<br>
2- Fitness score evaluation<br>
3- Selection<br>
4- Crossover<br>
5- Mutation<br>
The fitness score evaluation, selection, crossover and mutation will be repeated until a stop condition. This condition can be a specific number of iterations (called generation) or a threshold reached (satisfying result).
## Initial population generation
The first step is the initial population generation. A population contains a number of chromosomes. A chromosome is a potential solution and is composed of several characteristics (called genes). Each function parameter is a gene. So, for a function with 6 parameters, a chromosome has 6 genes (one for each parameter). The following figure is a representation of a 4 element population. Each chromosome contains 6 genes.
Usually, the initial population has a fixed size and is generated randomly. The population size is one important parameter for Genetic Algorithms.
![](https://github.com/AnasNedday/Genetic-Algo-SMA/raw/main/image1.png)
## Fitness score evaluation
Each chromosome from the population is evaluated to obtain a fitness score. Better is the solution, better will be its fitness score. The probability that a chromosome will be selected for reproduction is based on its fitness score. Concretely, the chromosome genes are used as parameters for the function the algorithm tries to minimize (or maximize). It is the crucial part of the algorithm: how to evaluate correctly the quality of a solution (set of parameters)? Without a good fitness score evaluation function, the Genetic Algorithm will not produce good results.
## Selection
Based on the fitness score, a percentage of the population will be selected for reproduction. The better is the fitness score, the higher is the probability to be selected. A second important parameter for Genetic Algorithms is the crossover rate. The crossover rate represents the percentage of the population selected from generation t to generation t+1 for reproduction.
## Crossover
The crossover step is the most related to biological reproduction. The chromosomes selected from the previous generation are mixed, two-by-two, to generate new chromosomes called children. These new chromosomes contain some elements from their two parents.
New chromosomes are generated until the population is complete (population number reaches). The bigger is the crossover rate, the fewer new chromosomes are generated.<br>
![](https://github.com/et-taoudi/GeneticAlgo/assets/79162585/54dc8af4-7d93-4853-aa71-9b7c943702d1)
## Mutation
The mutation step mimics the mutation during genetic reproduction. Each chromosome has a probability to mutate. If a mutation occurs, a random gene in the chromosome will be changed to another random value. The mutation rate is another important parameter: it represents the probability that a chromosome mutates.
This step is very important to obtain good results. Indeed, a Genetic Algorithm can be stuck in a local minimum (maximum). The mutation is a "jump" to another point in the solution space.<br>
![Chromosomes-genetic-arrangement-selection-crossover-and-mutation-procedures-in-the](https://github.com/et-taoudi/GeneticAlgo/assets/79162585/72a6a949-442a-40f1-aa45-5de3b9b7ab54)
## Implementation using SMA with Island Agent
![Capture d'écran 2023-05-27 161537](https://github.com/et-taoudi/GeneticAlgo/assets/79162585/55c8cc6f-cd18-4aa3-93c1-93168cdfc804)<br>
![Capture d'écran 2023-05-26 182927](https://github.com/et-taoudi/GeneticAlgo/assets/79162585/4f289b86-135f-42ab-a64f-6efa21d52573)

