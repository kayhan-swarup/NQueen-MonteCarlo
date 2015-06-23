package nqueen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Random;

import javax.swing.JPanel;

public class Queen extends JPanel{
	
	Ellipse2D.Double queen;
	
	int row,column,n;
	Queen pair;
	boolean isPaired;
	
	
	public Queen(int column,int n){
		this.n=n;this.column=column;
		queen=new Ellipse2D.Double(10,10,60,60);
		this.row = new Random().nextInt(n);
		setBackground(null);
	}

	public boolean isOK(){
		
		for(int i=0;i<NQueenSolution.queen.length;i++){
			if(NQueenSolution.queen[i]!=this)
			if(NQueenSolution.queen[i].column==this.column){
				System.out.println(NQueenSolution.queen[i].row+" "+NQueenSolution.queen[i].column+" \n"+row+" "+column);
				return false;
			}
			
		}
		for(int i=1,j=1;row-i>=0||column-j>=0;i++,j++){
			for(int k=0;k<NQueenSolution.queen.length;k++){
				if(NQueenSolution.queen[k]!=this&&NQueenSolution.queen[k].row==row-i&&NQueenSolution.queen[k].column==column-j){
					System.out.println(NQueenSolution.queen[k].row+" "+NQueenSolution.queen[k].column+" \n"+row+" "+column);
					return false;
				}
			}
		}
		for(int i=1,j=1;row-i>=0||column+j<NQueenSolution.queen.length;i++,j++){
			for(int k=0;k<NQueenSolution.queen.length;k++){
				if(NQueenSolution.queen[k]!=this&&NQueenSolution.queen[k].row==row-i&&NQueenSolution.queen[k].column==column+j){
					System.out.println(NQueenSolution.queen[k].row+" "+NQueenSolution.queen[k].column+" \n"+row+" "+column);
					return false;
				}
			}
		}
		for(int i=1,j=1;row+i<NQueenSolution.queen.length||column-j>=0;i++,j++){
			for(int k=0;k<NQueenSolution.queen.length;k++){
				if(NQueenSolution.queen[k]!=this&&NQueenSolution.queen[k].row==row+i&&NQueenSolution.queen[k].column==column-j){
					System.out.println(NQueenSolution.queen[k].row+" "+NQueenSolution.queen[k].column+" \n"+row+" "+column);
					return false;
				}
			}
		}
		
		for(int i=1,j=1;row+i<NQueenSolution.queen.length||column+j<NQueenSolution.queen.length;i++,j++){
			for(int k=0;k<NQueenSolution.queen.length;k++){
				if(NQueenSolution.queen[k]!=this&&NQueenSolution.queen[k].row==row+i&&NQueenSolution.queen[k].column==column+j){
					System.out.println(NQueenSolution.queen[k].row+" "+NQueenSolution.queen[k].column+" \n"+row+" "+column);
					return false;
				}
			}
		}
		
		
		return true;
	}
	
	
	public void setRow(int row){
		if(row>=n-1)
			return;
		this.row=row;
		Graphics g = getGraphics();
		if(getParent()!=null)
			getParent().remove(this);
		if(row!=-1&&column>-1&&ChessBoard.block[row][column]!=null)
		ChessBoard.block[row][column].add(this);
			
	}
	@Override
	public Dimension getPreferredSize() {
		// TODO Auto-generated method stub
		return new Dimension(100,100);
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		setBackground(column%2==row%2?Color.BLACK:Color.WHITE);
		setBackground(null);
		g2d.setColor(Color.RED);
			queen = new Ellipse2D.Double(10,10,160,160);
				g2d.fill(queen);
		
		
	}
	
	

}
