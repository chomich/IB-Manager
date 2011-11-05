package utils;

import javax.swing.*;

import javax.swing.plaf.basic.BasicTabbedPaneUI;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class TabbedPaneUI extends BasicTabbedPaneUI {

	private static final Insets NO_INSETS = new Insets(0, 0, 0, 0);
	private static final Color	selectedColor = new Color(200, 210, 220);
	private static final Color	defaultColor = new Color(240, 240, 240);
	private static final Color	hoverColor = new Color(235, 235, 235);
	private static final Color	lineColor = new Color(200, 210, 220);
	private static final Color	dividerColor = new Color(160, 160, 160);
	private static final int	tabHeight = 21;
	private Insets contentInsets = new Insets(10, 10, 10, 10);
	
	private boolean contentTopBorderDrawn = true;
	private int lastRollOverTab = -1;

//	public static ComponentUI createUI(JComponent c) {
//		return new TabbedPaneUI();
//	}

	public TabbedPaneUI() {
	
		maxTabHeight = 30;
		contentInsets = new Insets(0, 0, 0, 0);
	}

//	public void setContentTopBorderDrawn(boolean b) {
//		contentTopBorderDrawn = b;
//	}

//	public void setContentInsets(Insets inserts) {
//		contentInsets = inserts;
//	}

//	public void setContentInsets(int i) {
//		contentInsets = new Insets(i, i, i, i);
//	}

	public int getTabRunCount(JTabbedPane pane) {
		return 1;
	}

	protected void installDefaults() {
		super.installDefaults();

		RollOverListener l = new RollOverListener();
		tabPane.addMouseListener(l);
		tabPane.addMouseMotionListener(l);

		tabAreaInsets = NO_INSETS;
		tabInsets = new Insets(0, 0, 0, 1);
	}

//	protected boolean scrollableTabLayoutEnabled() {
//		return false;
//	}

	protected Insets getContentBorderInsets(int tabPlacement) {
		return contentInsets;
	}

	protected int calculateTabHeight(int tabPlacement, int tabIndex, int fontHeight) {
		return tabHeight;
	}

	protected int calculateTabWidth(int tabPlacement, int tabIndex, FontMetrics metrics) {
		return 180;
	}

	protected int calculateMaxTabHeight(int tabPlacement) {
		return tabHeight;
	}

	protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
		Graphics2D g2d = (Graphics2D) g;
		Rectangle rect = rects[tabIndex];
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		int width = rect.width;
		int xpos = rect.x;
		if (tabIndex > 0) {
			width--;
			xpos++;
		}


		if (isSelected)
			g2d.setPaint(selectedColor);
		else if (getRolloverTab() == tabIndex)
			g2d.setPaint(hoverColor);
		else 
			g2d.setPaint(defaultColor);
		
		g2d.fillRect(xpos, 0, width, 21);

		if (contentTopBorderDrawn) {
			g2d.setColor(lineColor);
			g2d.drawLine(rect.x, 20, rect.x + rect.width - 1, 20);
		}
	}

	protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
		Rectangle rect = getTabBounds(tabIndex, new Rectangle(x, y, w, h));
		g.setColor(dividerColor);
		g.drawLine(rect.x + rect.width, 0, rect.x + rect.width, 20);
	}

	protected void paintContentBorderTopEdge(Graphics g, int tabPlacement, int selectedIndex, int x, int y, int w, int h) {
	}

	protected void paintContentBorderRightEdge(Graphics g, int tabPlacement, int selectedIndex, int x, int y, int w, int h) {
	}

	protected void paintContentBorderLeftEdge(Graphics g, int tabPlacement,	int selectedIndex, int x, int y, int w, int h) {
	}

	protected void paintContentBorderBottomEdge(Graphics g, int tabPlacement, int selectedIndex, int x, int y, int w, int h) {		
	}

	protected void paintFocusIndicator(Graphics g, int tabPlacement,Rectangle[] rects, int tabIndex, Rectangle iconRect, Rectangle textRect, boolean isSelected) {
		// Do nothing
	}

	protected int getTabLabelShiftY(int tabPlacement, int tabIndex, boolean isSelected) {
		return 0;
	}

	private class RollOverListener implements MouseMotionListener, MouseListener {

		public void mouseDragged(MouseEvent e) {
		}

		public void mouseMoved(MouseEvent e) {
			checkRollOver();
		}

		public void mouseClicked(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
		}

		public void mouseReleased(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
			checkRollOver();
		}

		public void mouseExited(MouseEvent e) {
			tabPane.repaint();
		}

		private void checkRollOver() {
			int currentRollOver = getRolloverTab();
			if (currentRollOver != lastRollOverTab) {
				lastRollOverTab = currentRollOver;
				Rectangle tabsRect = new Rectangle(0, 0, tabPane.getWidth(), 20);
				tabPane.repaint(tabsRect);
			}
		}
	}
}