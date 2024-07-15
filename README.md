# Implementação em Java de autômatos celulares

Implementação em 1, 2 e 3 dimensões. Estado binários, e vizinhos diagonais não são considerados. Todos com uma única medida de dimensão, ou seja, no 2d, sempre um quadrado, e no 3d, sempre um cubo

# Unidimensional

Regras possíveis - de 0 a 255 (considerando extinção, superpopulação e estagnação)

Modelo mais simples de autômato, com poucas regras possíveis, porém com algumas que geram padrões interessantes

# Bidimensional

Regras possíveis - de 0 a 2^32 (considerando extinção, superpopulação, e estagnação)

Esse modelo cresce bastante no sentido de padrões possíveis através, tando da regra escolhida, que é basicamente do tamanho de um INT, quanto do número de evoluções do autômato

# Tridimensional

Único documentado

Regras possíveis - de 0 a 2^128 (considerando extinção, superpopulação, e estagnação)

Basicamente o foco do meu trabalho foi com o modelo de três dimensões, uma vez que a quantidade de regras é ridículamente grande (constituído por dois números do tipo LONG). A classe
CellularAutomata3D conta não só com a implementação básica do autômato, mas inclui geradores de números inteiros aleatórios, em vários níveis de qualidade, determinada pela quantidade
de recursividade utilizada no algoritmo. É bastante interessante ver a geração desses números a partir do autômato. Dependendo do nível da aleatoriedade escolhido, ele não costuma repetir
os números, mas de vez em quando acontece. Não sei dizer o quão bom é o algoritmo, no que tange a aleatoridade, uma vez que ele utiliza um fator da máquina como ponto de partida. Outra coisa
é que o algoritmo não está muito bem otimizado, e pode ser que processar os números leve algum tempo, dependendo da qualidade do algoritmo.

Além disso, possui também métodos estáticos para a obtenção da regra, o que é recomendável, visto que como a regra é constituídade de vários bits, se o número for pequeno, a regra terá muitos
zeros o que pode contribuir para uma extinção.

Por fim, a classe também possui dois métodos para o teste de qualidade da semente (conjunto da regra), que gera vários frames com com a semente, e checa se em algumas dessas iterações foram gerados 
padrões repetidos (frames idênticos, extinção, superpopulação, estagnação). fastSeedTest(regra) -> 100 iterações, goodSeedTest(regra) -> 100.000 iterações.

# Como utilizar?

Os três modelos são exatamente iguais na utilização, porém recomendo o modelo 3d, por possuir mais funcionalidades e estar mais detalhado.

Instancie o autômato usando o construtor que recebe dois parâmetros:

INT tamanho - largura da dimensão do autômato

INT regra - regra de transição

Long[] regra - no caso do automato3d (recomendação: utilize o CellularAutomata3D.getRandomRule())

Use o metodo nextGen() para transicionar o autômato, aplicando a regra passada no construtor. Você pode utilizar este método quantas vezes quiser.

Use os métodos getFrame() e getFormatedFrame() para visualizar o estado dos autômatos. O getFrame() retorna uma representação linear do autômato, já o getFormatedFrame() retorna
representação mais geométrica do autômato, facilitando a visualização e compreenssão de como a regra atua sobre ele (linha para o caso do 1D, um quadrado para o 2D, e as "fatias" do cubo, no caso do 3D). 
