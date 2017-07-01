package javax.swing;

import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Graphics;
import java.net.URL;

public class JImagePanel extends javax.swing.JPanel
{
  private URL imgURL    = null;
  private Image img     = null;

  public JImagePanel()
  {
  }
  public JImagePanel(URL imgURL)
  {
    this.imgURL = imgURL;
    init();
  }
  public void setImage(URL imgURL)
  {
    imgURL = imgURL;
  }
  private void init()
  {
    MediaTracker mt = new MediaTracker(this);
    img             = getToolkit().createImage(imgURL);
    mt.addImage(img,0);
    try
    {
      mt.waitForAll();
    }
    catch(Exception e)
    {}
  }
  public void paint(Graphics g)
  {
    if(img != null)
      g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);
  }
}