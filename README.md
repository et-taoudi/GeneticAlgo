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
![](https://cylab.be/storage/blog/172/files/SkqyeAmd0OV6tal7/chromosome.png)
