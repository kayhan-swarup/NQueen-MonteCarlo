package nqueen;

import java.awt.FlowLayout;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.SliderUI;

public class NQueenSolution extends JFrame{
	public static Queen[] queen=null ;
	public static int n;
	public static ChessBoard chessBoard;
	
	public NQueenSolution(int n){
		this.n = n;
		this.queen=new Queen[n];
		for(int i=0;i<n;i++){
			queen[i] = new Queen(i, n);
		}
		chessBoard = new ChessBoard(n);
	}
	public static int[] generateRandom(){
		Random random = new Random();
		int[] x = new int[n];
		for(int i=0;i<n;i++){
			x[i] = random.nextInt(n);
		}
		return x;
	}
	
	
	
	public static void MonteCarlo(int steps){
		int count = 0;
		while(count<steps){
			int[] solution = generateRandom();
			for(int i=0;i<n;i++){
				chessBoard.moveQueen(queen[i],solution[i]);
				try {
					chessBoard.repaint();
					Thread.sleep(20);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(queen[0].isOK()&&queen[1].isOK()&&queen[2].isOK()&&queen[3].isOK()){
					System.out.println("Count:"+count);
					chessBoard.repaint();
					return;
				}
			}
			count++;
		}
		System.out.println("Count:"+count);
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NQueenSolution nQueen = new NQueenSolution(4);
		nQueen.setVisible(true);
		nQueen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		nQueen.setBounds(300,0,800,800);
//		nQueen.setLayout(null);
//		chessBoard.setBounds(0,0,800,800);
		nQueen.add(chessBoard);
		for(int i=0;i<queen.length;i++){
			chessBoard.addQueen(queen[i],i,0);
		}

		
//		chessBoard.moveQueen(queen[1], 1);
//		System.out.println(queen[2].isOK());
		MonteCarlo(500);

	}

}
