import javax.swing.*;
import java.awt.*;

public class SliderPuzzleFrame extends JFrame
{
    private SliderPuzzlePanel mainPanel;

    public SliderPuzzleFrame()
    {
        super("Slider Puzzle");
        mainPanel = new SliderPuzzlePanel();
        setSize(800,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        buildGUI();
    }

    public void buildGUI()
    {
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(mainPanel,BorderLayout.CENTER);
    }

}
