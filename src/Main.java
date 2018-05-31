import com.geneticalgorithm.*;
import com.neuralnetwork.*;
import com.probabilisticlearner.*;
import com.tictactoe.*;
import java.util.Arrays;


class Main {
    public static void main(String[] args) {
	/*{	
		System.out.println("no bias XOR");
		double[][] inputs = {{0,0},{0,1},{1,0},{1,1}};
		double[][][] weights = {{{1,1},{-1,-1}},{{1,1}}};

		IActivationFunction[][] activationFunctions = new IActivationFunction[2][2];
		activationFunctions[0][0] = new StepActivationFunction(0.5);
		activationFunctions[0][1] = new StepActivationFunction(-1.5);
		activationFunctions[1][0] = new StepActivationFunction(1.5);

		NeuralNetwork n = new NeuralNetwork(weights, null, activationFunctions);

		for ( int input = 0; input < 4; input++) 
		{
			double[] outputs = n.Activate(inputs[input]);
			System.out.println("[" + inputs[input][0] + ", " + inputs[input][1] + "] = " + outputs[0]);
		}
	}
	{
		System.out.println("Bias XOR");
		double[][] inputs = {{0,0},{0,1},{1,0},{1,1}};
		double[][][] weights = {{{1,1},{-1,-1}},{{1,1}}};
		double[][] biases = {{0,2}, {-1,0}};
		IActivationFunction[][] activationFunctions = new IActivationFunction[2][3];
		activationFunctions[0][0] = new BinaryActivationFunction();
		activationFunctions[0][1] = new BinaryActivationFunction();
		activationFunctions[1][0] = new BinaryActivationFunction();

		NeuralNetwork n = new NeuralNetwork(weights, biases, activationFunctions);

		for ( int input = 0; input < 4; input++) 
		{
			double[] outputs = n.Activate(inputs[input]);
			System.out.println("[" + inputs[input][0] + ", " + inputs[input][1] + "] = " + outputs[0]);
		}
		
	}
	{
		System.out.println("Sigmoid XOR");
		double[][] inputs = {{0,0},{0,1},{1,0},{1,1}};
		double[][][] weights = {{{1,1},{-1,-1}},{{1,1}}};
		double[][] biases = {{0,2}, {-1,0}};
		IActivationFunction[][] activationFunctions = new IActivationFunction[2][3];
		activationFunctions[0][0] = new SigmoidActivationFunction();
		activationFunctions[0][1] = new SigmoidActivationFunction();
		activationFunctions[1][0] = new SigmoidActivationFunction();

		NeuralNetwork n = new NeuralNetwork(weights, biases, activationFunctions);

		for ( int input = 0; input < 4; input++) 
		{
			double[] outputs = n.Activate(inputs[input]);
			System.out.println("[" + inputs[input][0] + ", " + inputs[input][1] + "] = " + outputs[0]);
		}
		
	}

*/
/*        {
            PercentReproductionFunction repro = new PercentReproductionFunction ( 0.2, 0.1, 1.0 );

            double[][][] weights = {{{0,0},{0,0}},{{0,0}}};
            IActivationFunction[][] activationFunctions = new IActivationFunction[2][3];
            activationFunctions[0][0] = new BinaryActivationFunction();
            activationFunctions[0][1] = new BinaryActivationFunction();
            activationFunctions[1][0] = new BinaryActivationFunction();

            GeneticAlgorithm n = new GeneticAlgorithm(42, 0, weights, null, activationFunctions);
            System.out.println("Name: " + n.getName());

            int generation_count = 10;

            GeneticAlgorithm[] networks = new GeneticAlgorithm[generation_count];
            for ( int network = 0; network < generation_count; network++ ) {
                networks[network] = new GeneticAlgorithm(network, 0, weights, null, activationFunctions);
            }
            System.out.println ( "Generation 0");
            for ( int network = 0; network < generation_count; network++ ) {
                System.out.println("Name: " + networks[network].getName());
                networks[network].printWeights();
            }
            networks = repro.doIt( 1, networks );

            System.out.println ( "Generation 1");
            for ( int network = 0; network < generation_count; network++ ) {
                System.out.println("Name: " + networks[network].getName());
                networks[network].printWeights();
            }


        }*/
/*
        {
            System.out.println("Genetic Algorithm XOR Binary");

            XORGeneration gen = new XORBinaryGeneration( 100 );
            gen.evolve ( 100 );
        }
        */
/*
        {
            System.out.println("Genetic Algorithm XOR Sigmoid");

            XORGeneration gen = new XORSigmoidGeneration(100 );
   //         gen.evolve(1000);
        }
        */
/*
        {
            int[][] Inputs = {{ 0,0 },{ 1,0 },{ 0,1 },{ 1,1 }};
            System.out.println("XOR Probabilistic Learner");
            BinaryProbabilisticLearner XORPL = new BinaryProbabilisticLearner (2 );
            System.out.println ( "Untaught");
            for ( int loop = 0; loop < Inputs.length; loop++) {
                System.out.println(Arrays.toString(Inputs[loop])+ " - >" + Arrays.toString(XORPL.test ( Inputs[loop] )));
            }

            for ( int teaching_iterations = 0; teaching_iterations < 100; teaching_iterations++ ) {
                int[] Outputs = {0, 1, 1, 0};
                for (int loop = 0; loop < Inputs.length; loop++)
                    XORPL.teach(Inputs[loop], Outputs[loop]);
            }

            System.out.println ( "Taught");
            for ( int loop = 0; loop < Inputs.length; loop++) {
                System.out.println(Arrays.toString(Inputs[loop])+ " - >" + Arrays.toString(XORPL.test ( Inputs[loop] )));
            }
        }
        */
/*
        {
            String[] Inputs = { "00", "10", "01", "11" };
            System.out.println("XOR Probabilistic Learner");
            SingletOutputProbabilisticLearner XORPL = new SingletOutputProbabilisticLearner (2 );
            System.out.println ( "Untaught");
            for ( int loop = 0; loop < Inputs.length; loop++) {
                System.out.println(Inputs[loop] + " - >" + XORPL.test ( Inputs[loop] ));
            }

            for ( int teaching_iterations = 0; teaching_iterations < 100; teaching_iterations++ ) {
                String[] Outputs = {"10", "01", "01", "10"};
                for (int loop = 0; loop < Inputs.length; loop++)
                    XORPL.teach(Inputs[loop], Outputs[loop]);
            }

            System.out.println ( "Taught");
            for ( int loop = 0; loop < Inputs.length; loop++) {
                System.out.println(Inputs[loop] + " - >" + XORPL.test ( Inputs[loop] ));
            }
        }
*/
/*
        {
            /* Tic-tac-toe board positions
             *   1 2 3
             *   4 5 6
             *   7 8 9
             *
             *   9 inputs which can be 'X', 'O', '.'
             *
             * /
            SingletOutputProbabilisticLearner TTT = new SingletOutputProbabilisticLearner(9);

            TTT.reinforce(".........", "100000000", 10);
            TTT.reinforce("10.......", "000000100", 10);
            TTT.reinforce("10.0..1..", "000000001", 10);
            TTT.reinforce("10.00.1.1", "000000010", 10);
            TTT.reinforce("10.0..101", "000010000", 10);
            System.out.println("Host first move: " + TTT.evaluate("........."));
            System.out.println("Host second move: " + TTT.evaluate("XO......."));

            String TheBoard = ".........";

            TicTacToeBoard ttt = new TicTacToeBoard();
            ttt.printBoard();
            if ( ttt.playX ( 0 ) == TicTacToeBoard.moveResult.Won )
                System.out.println("X won");
            ttt.printBoard();
            if ( ttt.playX ( 4 ) == TicTacToeBoard.moveResult.Won )
                System.out.println("X won");
            ttt.printBoard();
            if ( ttt.playX ( 8 ) == TicTacToeBoard.moveResult.Won )
                System.out.println("X won");
            ttt.printBoard();
        }
        */
/*
        {
            // head to head training
            TicTacToePlayer XPlayer = new TicTacToePlayer("X");
            TicTacToePlayer OPlayer = new TicTacToePlayer("O");

            int XGamesWon = 0;
            int OGamesWon = 0;
            int CatsGames = 0;

            // learning mode
            for (int gamesPlayed = 0; gamesPlayed < 500000; gamesPlayed++) {
                {
                    TicTacToeGame game = new TicTacToeGame(XPlayer, OPlayer);
                    switch (game.Play()) {
                        case None:
                            break;
                        case Tie:
                            CatsGames++;
                            break;
                        case X:
                            XGamesWon++;
                            break;
                        case O:
                            OGamesWon++;
                            break;
                    }
                    XPlayer.learn();
                    OPlayer.learn();
                }
            }
            System.out.println ( "During training: ");
            System.out.println ( "X games won: " + XGamesWon );
            System.out.println ( "O games won: " + OGamesWon );
            System.out.println ( "Cats games won: " + CatsGames );
            XGamesWon = 0;
            OGamesWon = 0;
            CatsGames = 0;

            // play a few games
            for (int gamesPlayed = 0; gamesPlayed < 10; gamesPlayed++) {
                {
                    TicTacToeGame game = new TicTacToeGame( XPlayer, OPlayer);
                    switch (game.Play(true)) {
                        case None:
                            break;
                        case Tie:
                            CatsGames++;
                            break;
                        case X:
                            XGamesWon++;
                            break;
                        case O:
                            OGamesWon++;
                            break;
                    }
                }
            }

            System.out.println ( "During competition: ");
            System.out.println ( "X games won: " + XGamesWon );
            System.out.println ( "O games won: " + OGamesWon );
            System.out.println ( "Cats games won: " + CatsGames );
        }
*/
/*
        {
            // private training
            TicTacToePlayer XPlayer = new TicTacToePlayer("X");
            TicTacToePlayer XTrainer = new TicTacToePlayer("O");


            TicTacToePlayer OPlayer = new TicTacToePlayer("O");
            TicTacToePlayer OTrainer = new TicTacToePlayer("X");

            int XGamesWon = 0;
            int OGamesWon = 0;
            int CatsGames = 0;

            // learning mode
            for (int gamesPlayed = 0; gamesPlayed < 500000; gamesPlayed++) {
                {
                    TicTacToeGame game = new TicTacToeGame(XPlayer, XTrainer);
                    switch (game.Play()) {
                        case None:
                            break;
                        case Tie:
                            CatsGames++;
                            break;
                        case X:
                            XGamesWon++;
                            break;
                        case O:
                            OGamesWon++;
                            break;
                    }
                    XPlayer.learn();
                }
            }
            System.out.println ( "During X training: ");
            System.out.println ( "X games won: " + XGamesWon );
            System.out.println ( "O games won: " + OGamesWon );
            System.out.println ( "Cats games won: " + CatsGames );
            XGamesWon = 0;
            OGamesWon = 0;
            CatsGames = 0;

            // learning mode
            for (int gamesPlayed = 0; gamesPlayed < 500000; gamesPlayed++) {
                {
                    TicTacToeGame game = new TicTacToeGame(OTrainer, OPlayer);
                    switch (game.Play()) {
                        case None:
                            break;
                        case Tie:
                            CatsGames++;
                            break;
                        case X:
                            XGamesWon++;
                            break;
                        case O:
                            OGamesWon++;
                            break;
                    }
                    OPlayer.learn();
                }
            }
            System.out.println ( "During O training: ");
            System.out.println ( "X games won: " + XGamesWon );
            System.out.println ( "O games won: " + OGamesWon );
            System.out.println ( "Cats games won: " + CatsGames );
            XGamesWon = 0;
            OGamesWon = 0;
            CatsGames = 0;

            // play a few games
            for (int gamesPlayed = 0; gamesPlayed < 10; gamesPlayed++) {
                {
                    TicTacToeGame game = new TicTacToeGame( XPlayer, OPlayer);
                    switch (game.Play(true)) {
                        case None:
                            break;
                        case Tie:
                            CatsGames++;
                            break;
                        case X:
                            XGamesWon++;
                            break;
                        case O:
                            OGamesWon++;
                            break;
                    }
                }
            }

            System.out.println ( "During competition: ");
            System.out.println ( "X games won: " + XGamesWon );
            System.out.println ( "O games won: " + OGamesWon );
            System.out.println ( "Cats games won: " + CatsGames );
        }
        */
        {
            // private training then head to head
            TicTacToePlayer XPlayer = new TicTacToePlayer("X");
            TicTacToePlayer XCopy = new TicTacToePlayer("X");
            TicTacToePlayer XTrainer = new TicTacToePlayer("O");


            TicTacToePlayer OPlayer = new TicTacToePlayer("O");
            TicTacToePlayer OCopy = new TicTacToePlayer("O");
            TicTacToePlayer OTrainer = new TicTacToePlayer("X");

            int XGamesWon = 0;
            int OGamesWon = 0;
            int CatsGames = 0;

            // learning mode
            for (int gamesPlayed = 0; gamesPlayed < 500000; gamesPlayed++) {
                {
                    TicTacToeGame game = new TicTacToeGame(XPlayer, XTrainer);
                    switch (game.Play()) {
                        case None:
                            break;
                        case Tie:
                            CatsGames++;
                            break;
                        case X:
                            XGamesWon++;
                            break;
                        case O:
                            OGamesWon++;
                            break;
                    }
                    XPlayer.learn(false);
                    XCopy.learn(false);
                }
            }
            for (int gamesPlayed = 0; gamesPlayed < 500000; gamesPlayed++) {
                {
                    TicTacToeGame game = new TicTacToeGame(OTrainer, OPlayer);
                    switch (game.Play()) {
                        case None:
                            break;
                        case Tie:
                            CatsGames++;
                            break;
                        case X:
                            XGamesWon++;
                            break;
                        case O:
                            OGamesWon++;
                            break;
                    }
                    OPlayer.learn(false);
                    OCopy.learn(false);
                }
            }
            for (int gamesPlayed = 0; gamesPlayed < 500000; gamesPlayed++) {
                {
                    TicTacToeGame game = new TicTacToeGame(XPlayer, OCopy);
                    switch (game.Play()) {
                        case None:
                            break;
                        case Tie:
                            CatsGames++;
                            break;
                        case X:
                            XGamesWon++;
                            break;
                        case O:
                            OGamesWon++;
                            break;
                    }
                    XPlayer.learn(true);
                }
            }
            for (int gamesPlayed = 0; gamesPlayed < 500000; gamesPlayed++) {
                {
                    TicTacToeGame game = new TicTacToeGame(XCopy, OPlayer);
                    switch (game.Play()) {
                        case None:
                            break;
                        case Tie:
                            CatsGames++;
                            break;
                        case X:
                            XGamesWon++;
                            break;
                        case O:
                            OGamesWon++;
                            break;
                    }
                    OPlayer.learn(true);
                }
            }
            System.out.println ( "During O training: ");
            System.out.println ( "X games won: " + XGamesWon );
            System.out.println ( "O games won: " + OGamesWon );
            System.out.println ( "Cats games won: " + CatsGames );
            XGamesWon = 0;
            OGamesWon = 0;
            CatsGames = 0;

            // play a few games
            for (int gamesPlayed = 0; gamesPlayed < 10; gamesPlayed++) {
                {
                    TicTacToeGame game = new TicTacToeGame( XPlayer, OPlayer);
                    switch (game.Play(true)) {
                        case None:
                            break;
                        case Tie:
                            CatsGames++;
                            break;
                        case X:
                            XGamesWon++;
                            break;
                        case O:
                            OGamesWon++;
                            break;
                    }
                }
            }

            System.out.println ( "During competition: ");
            System.out.println ( "X games won: " + XGamesWon );
            System.out.println ( "O games won: " + OGamesWon );
            System.out.println ( "Cats games won: " + CatsGames );
        }
    }
}