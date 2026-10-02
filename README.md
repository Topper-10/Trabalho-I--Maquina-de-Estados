Máquina de Estados Finitos (State Pattern)
Simulador em Java que implementa uma Máquina de Estados Finitos (FSM) com o padrão de projeto State para gerenciar a rotina de personagens em um cenário medieval.

Como Compilar e Rodar
O projeto utiliza apenas recursos nativos do Java e tem seu ponto de partida no método main da classe FSM. Para executá-lo, certifique-se de ter o Java Development Kit (JDK) instalado e mantenha os 11 arquivos .java (AbstractState.java, Character.java, State.java, FSM.java, Blacksmith.java, Guard.java, Warming.java, Hitting.java, Marching.java, Guarding.java e OffDuty.java) na mesma pasta.

Pelo Terminal (Linha de Comando):

Abra o terminal na pasta onde os arquivos .java estão salvos.

Compile todos os arquivos do projeto com o comando:

javac *.java

Inicie a simulação executando a classe principal:   

java FSM

Pela IDE (IntelliJ IDEA, Eclipse, VS Code):

Abra a pasta contendo os arquivos de código-fonte no seu projeto Java.

Localize o arquivo FSM.java e execute o método public static void main(String[] args)

Descrição dos Agentes e Estados
A cada rodada do laço principal, o programa chama o método update() de cada personagem da lista, que delega a ação do turno para o método execute() do estado atual e utiliza os métodos leave() e enter() durante as trocas de estado:
1. Ferreiro (Blacksmith)
   Trabalha na forja, lidando com a temperatura (temperature) e a quantidade de marteladas (hits), começando no estado Warming:
        1.1 Warming (Aquecendo): Aumenta a temperatura do metal em +40 graus por rodada através do método warmingMetal(40). Quando atinge temperature >= 100, muda para o estado Hitting. Ao entrar neste estado (enter), verifica o motivo do retorno: se a espada anterior foi concluída (hits >= 5), zera hits e temperature para começar uma nova peça; se o metal apenas esfriou (temperature < 50), retoma o aquecimento mantendo os golpes já dados.
        1.2 Hitting (Martelando): Soma +1 golpe na espada via hittingMetal(1) e reduz a temperatura aleatoriamente entre 0 e 29 graus via coolingMetal(30) a cada rodada. Retorna para o estado Warming quando completa as 5 marteladas da espada (hits >= 5) ou quando a temperatura cai abaixo de 50 graus (temperature < 50).
2. Guarda (Guard)
    Cuida da segurança do castelo controlando as voltas de patrulha (march) e as horas passadas (time), iniciando sua rotina no estado Marching: 
        2.1 Marching (Marchando): Soma +1 volta ao redor do castelo por rodada através de marchAround(1). Ao atingir march >= 5, muda para o estado Guarding e zera o contador de voltas (setMarch(0)) para deixar a contagem pronta para a próxima patrulha.    
        2.2 Guarding (Vigiando): Soma +1 hora de vigilância na entrada por rodada através de passTime(1). Ao atingir time >= 5, zera o contador de horas na saída do estado (leave) e muda para OffDuty.
        2.2 OffDuty (Fora de Turno): Soma +1 hora de descanso por rodada através de passTime(1). Ao alcançar time >= 8, zera o contador de horas na saída (leave) e volta para o estado Marching.

Como Observar as Transições nos Logs
   O método update() de cada personagem executa o turno e imprime uma linha divisória (==============) no final. Você pode identificar facilmente quando um personagem apenas continuou sua tarefa ou quando mudou de estado observando o número de linhas exibidas antes da divisória:
Guarda
Marchando ao redor do castelo(Voltas: 4)
==============
Ferreiro
Aquecendo metal (Calor: 120)
Metal quente!
Indo para a bigorna
=============

Grupo 8 
Gabriel Pelisson Gonçalves de Lima
Paulo Henrique Cavichiolo Franco Ferrari
