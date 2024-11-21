/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.vista;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author USER
 */
class FondoPanel extends javax.swing.JPanel{
        private Image imagen;
        
        public FondoPanel(String link){
            imagen = new ImageIcon(link).getImage();
        }
        
        public void setImagen(String link){
            imagen = new ImageIcon(link).getImage();
        }
        
        
        @Override
        public void paint(Graphics g){
            g.drawImage(imagen,0,0,getWidth(),getHeight(),this);
            setOpaque(false);
            super.paint(g);
        }
    }