package edu.nju.presentation.widget;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.plaf.basic.BasicScrollPaneUI;

public class MyScrollPane extends JScrollPane{
	public MyScrollPane() {
		// TODO Auto-generated constructor stub
		setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(240, 240, 240)));
		setViewportBorder(BorderFactory.createEmptyBorder());
		setOpaque(false);
		getViewport().setOpaque(false);
		//setUI(new BasicScrollPaneUI());
		//setVerticalScrollBar(new MyScrollBar());
		//setHorizontalScrollBar(new MyScrollBar());
	}
}
class MyScrollBar extends JScrollBar{
	public MyScrollBar() {
		// TODO Auto-generated constructor stub
		setUI(new MyScrollBarUI());
	}
}
class MyScrollBarUI extends BasicScrollBarUI{
	@Override
	protected JButton createDecreaseButton(int orientation) {
		// TODO Auto-generated method stub
		return new JButton();
	}
	@Override
	protected JButton createIncreaseButton(int orientation) {
		// TODO Auto-generated method stub
		 return new JButton();
	}
	@Override
	protected void installDefaults() {
		// TODO Auto-generated method stub
		super.installDefaults();
		scrollBarWidth = 10;
        
        minimumThumbSize = (Dimension)UIManager.get("ScrollBar.minimumThumbSize");
        maximumThumbSize = (Dimension)UIManager.get("ScrollBar.maximumThumbSize");

        Boolean absB = (Boolean)UIManager.get("ScrollBar.allowsAbsolutePositioning");
       // supportsAbsolutePositioning = (absB != null) ? absB.booleanValue() :
                                    //  false;

        trackHighlight = NO_HIGHLIGHT;
        if (scrollbar.getLayout() == null ||
                     (scrollbar.getLayout() instanceof UIResource)) {
            scrollbar.setLayout(this);
        }
        configureScrollBarColors();
        LookAndFeel.installBorder(scrollbar, "ScrollBar.border");
        LookAndFeel.installProperty(scrollbar, "opaque", Boolean.TRUE);

        //scrollBarValue = scrollbar.getValue();

        incrGap = UIManager.getInt("ScrollBar.incrementButtonGap");
        decrGap = UIManager.getInt("ScrollBar.decrementButtonGap");

        // TODO this can be removed when incrGap/decrGap become protected
        // handle scaling for sizeVarients for special case components. The
        // key "JComponent.sizeVariant" scales for large/small/mini
        // components are based on Apples LAF
        String scaleKey = (String)scrollbar.getClientProperty(
                "JComponent.sizeVariant");
        if (scaleKey != null){
            if ("large".equals(scaleKey)){
                scrollBarWidth *= 1.15;
                incrGap *= 1.15;
                decrGap *= 1.15;
            } else if ("small".equals(scaleKey)){
                scrollBarWidth *= 0.857;
                incrGap *= 0.857;
                decrGap *= 0.714;
            } else if ("mini".equals(scaleKey)){
                scrollBarWidth *= 0.714;
                incrGap *= 0.714;
                decrGap *= 0.714;
            }
        }
	}
}
