import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SliderPuzzleFrame extends JFrame implements ActionListener
{
    private SliderPuzzlePanel mainPanel;
    private JButton resetButton;

    public SliderPuzzleFrame()
    {
        super("Slider Puzzle");
        mainPanel = new SliderPuzzlePanel();
        setSize(564,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        buildGUI();
    }

    public void buildGUI()
    {
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(mainPanel,BorderLayout.CENTER);
        resetButton = new JButton("Reset");
        getContentPane().add(resetButton,BorderLayout.SOUTH);
        resetButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetButton)
            mainPanel.shuffle();
    }
}
