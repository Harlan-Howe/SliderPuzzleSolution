import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SliderPuzzlePanel extends JPanel implements MouseListener
{
    private int[][] myGrid = {{0,1,2,3},{4,5,6,7},{8,9,10,11},{12,13,14,-1}};
    private Image[] icons;
    private int cellSize;
    private int[] blankSpot = {3,3};

    public SliderPuzzlePanel()
    {
        super();
        icons = new Image[15];
        for (int r = 1; r <= 4; r++)
            for (int c = 1; c <= 4; c++)
            {
                if ((c-1)*4+(r-1) == 15)
                    break;
                ImageIcon tempIcon = new ImageIcon("SealParts/Kinkaid Seal-0" + r + "-0" + c + ".png");
                icons[(c-1)*4+(r-1)] = tempIcon.getImage();
            }
        cellSize = icons[0].getWidth(this);
        shuffle();
        addMouseListener(this);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        for (int r=0; r < 4; r++)
            for (int c=0; c < 4; c++)
            {
                if (myGrid[r][c]>=0)
                    g.drawImage(icons[myGrid[r][c]], c*cellSize, r*cellSize, this);
            }
    }

    public boolean slidePiece(int r, int c)
    {
        if (r<0 || r>3 || c<0 || c>3)
            return false;
        if (Math.abs(r-blankSpot[0])+ Math.abs(c-blankSpot[1])==1)
        {
            myGrid[blankSpot[0]][blankSpot[1]] = myGrid[r][c];
            myGrid[r][c] = -1;
            blankSpot[0] = r;
            blankSpot[1] = c;
            return true;
        }
        return false;
    }

    public void shuffle()
    {
        int numMoves=0;
        for (int i = 0; i< 2000; i++)
        {
            if (Math.random()<0.5)
                if (slidePiece(blankSpot[0], blankSpot[1]+(int)(Math.random()*2)*2-1))
                    numMoves++;
            else
                if (slidePiece(blankSpot[0]+(int)(Math.random()*2)*2-1,blankSpot[1]))
                    numMoves++;
        }
        System.out.println("Made "+numMoves+" slides.");
        repaint();
    }


    @Override
    public void mouseClicked(MouseEvent e)
    {

    }

    @Override
    public void mousePressed(MouseEvent e)
    {

    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        int r = e.getY()/cellSize;
        int c = e.getX()/cellSize;
        slidePiece(r,c);
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {

    }

    @Override
    public void mouseExited(MouseEvent e)
    {

    }
}
