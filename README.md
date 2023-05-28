# Genetic Algorithm
## Genetic Algorithm Structure
A Genetic Algorithm is an evolutive process that maintains a population of chromosomes (potential solutions). Each chromosome is composed of several characteristics called genes. The all process has 5 main steps:
1- Initial population generation<br>
2- Fitness score evaluation<br>
3- Selection<br>
4- Crossover<br>
5- Mutation<br>
![](https://cylab.be/storage/blog/172/files/Mjmxx5pGCh4mMjKC/2021-09-08_11-02.png)
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
New chromosomes are generated until the population is complete (population number reaches). The bigger is the crossover rate, the fewer new chromosomes are generated.
![](https://d3i71xaburhd42.cloudfront.net/73a50124700c7b2e44e3a72a298f6279a8b54ac3/13-Figure2-1.png)
