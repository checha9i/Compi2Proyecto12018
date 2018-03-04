/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Acciones.Compilador;
import Acciones.Historial;
import Acciones.ListaCSS;
import Acciones.RecorrerArbol;
import Analizadores.Lexico;
import Analizadores.Sintactico;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


/**
 *
 * @author chech
 */
public class UsacWeb extends javax.swing.JFrame {

    /**
     * Creates new form UsacWeb
     */
    public int ContPestañas=1;
    JPanel pintar=new JPanel();
    
      JScrollPane añadirpintar=new JScrollPane();
   public  ArrayList<ListaCSS> lista=new ArrayList<ListaCSS>();
    ArrayList<Historial> historial=new ArrayList<Historial>();  
     public int conthist;
     
    public UsacWeb() {
     
   
        initComponents();
        Plantilla ventana=new Plantilla();
       jToolBar1.setPreferredSize(new Dimension(106, 32));
       jToolBar1.setLocation(0, 0);
      MostrarPagina.setPreferredSize(new Dimension(1192, 389));
    //  MostrarPagina.setLayout(new FlowLayout(FlowLayout.LEFT));
           pintar.setBackground(Color.white);
    
     pintar.setLayout(null);
        pintar.setPreferredSize(new Dimension(1192, 389));
        añadirpintar.setBorder(BorderFactory.createLineBorder(Color.white));
        pintar.setBorder(BorderFactory.createLineBorder(Color.white));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pestañas = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        Plantilla = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        Entrada = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        MostrarPagina = new javax.swing.JPanel();
        jToolBar2 = new javax.swing.JToolBar();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        Plantilla2 = new javax.swing.JPanel();
        jToolBar5 = new javax.swing.JToolBar();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        Entrada2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        MostrarPagina2 = new javax.swing.JPanel();
        jToolBar6 = new javax.swing.JToolBar();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Pestañas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Pestañas.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                PestañasStateChanged(evt);
            }
        });
        Pestañas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PestañasMouseClicked(evt);
            }
        });
        Pestañas.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                PestañasComponentHidden(evt);
            }
        });

        jToolBar1.setRollover(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/regresar.png"))); // NOI18N
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/avanzar.png"))); // NOI18N
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/restart.png"))); // NOI18N
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        Entrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EntradaActionPerformed(evt);
            }
        });
        jToolBar1.add(Entrada);

        jLabel1.setText("USACWEB");
        jLabel1.setAlignmentX(0.5F);

        MostrarPagina.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout MostrarPaginaLayout = new javax.swing.GroupLayout(MostrarPagina);
        MostrarPagina.setLayout(MostrarPaginaLayout);
        MostrarPaginaLayout.setHorizontalGroup(
            MostrarPaginaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1311, Short.MAX_VALUE)
        );
        MostrarPaginaLayout.setVerticalGroup(
            MostrarPaginaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 447, Short.MAX_VALUE)
        );

        jToolBar2.setRollover(true);

        jButton4.setText("OPCIONES");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(jButton4);

        jButton5.setText("HISTORIAL");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton5);

        jButton6.setText("Añadir A Favoritos");
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton6);

        javax.swing.GroupLayout PlantillaLayout = new javax.swing.GroupLayout(Plantilla);
        Plantilla.setLayout(PlantillaLayout);
        PlantillaLayout.setHorizontalGroup(
            PlantillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, 1311, Short.MAX_VALUE)
            .addGroup(PlantillaLayout.createSequentialGroup()
                .addGap(532, 532, 532)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
            .addComponent(MostrarPagina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PlantillaLayout.setVerticalGroup(
            PlantillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PlantillaLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MostrarPagina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Plantilla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Plantilla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );

        Pestañas.addTab("Pagina1", jPanel1);

        jToolBar5.setRollover(true);

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/regresar.png"))); // NOI18N
        jButton13.setFocusable(false);
        jButton13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton13.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar5.add(jButton13);

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/avanzar.png"))); // NOI18N
        jButton14.setFocusable(false);
        jButton14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton14.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jToolBar5.add(jButton14);

        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/restart.png"))); // NOI18N
        jButton15.setFocusable(false);
        jButton15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton15.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jToolBar5.add(jButton15);

        Entrada2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Entrada2ActionPerformed(evt);
            }
        });
        jToolBar5.add(Entrada2);

        jLabel3.setText("USACWEB");
        jLabel3.setAlignmentX(0.5F);

        MostrarPagina2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout MostrarPagina2Layout = new javax.swing.GroupLayout(MostrarPagina2);
        MostrarPagina2.setLayout(MostrarPagina2Layout);
        MostrarPagina2Layout.setHorizontalGroup(
            MostrarPagina2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        MostrarPagina2Layout.setVerticalGroup(
            MostrarPagina2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 447, Short.MAX_VALUE)
        );

        jToolBar6.setRollover(true);

        jButton16.setText("OPCIONES");
        jButton16.setFocusable(false);
        jButton16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton16.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar6.add(jButton16);

        jButton17.setText("HISTORIAL");
        jButton17.setFocusable(false);
        jButton17.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton17.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jToolBar6.add(jButton17);

        jButton18.setText("Añadir A Favoritos");
        jButton18.setFocusable(false);
        jButton18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton18.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jToolBar6.add(jButton18);

        javax.swing.GroupLayout Plantilla2Layout = new javax.swing.GroupLayout(Plantilla2);
        Plantilla2.setLayout(Plantilla2Layout);
        Plantilla2Layout.setHorizontalGroup(
            Plantilla2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jToolBar6, javax.swing.GroupLayout.DEFAULT_SIZE, 1311, Short.MAX_VALUE)
            .addGroup(Plantilla2Layout.createSequentialGroup()
                .addGap(532, 532, 532)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
            .addComponent(MostrarPagina2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Plantilla2Layout.setVerticalGroup(
            Plantilla2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Plantilla2Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MostrarPagina2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(Plantilla2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(Plantilla2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );

        Pestañas.addTab("+", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pestañas)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pestañas)
        );

        Pestañas.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PestañasStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_PestañasStateChanged

        // TODO add your handling code here:
    }//GEN-LAST:event_PestañasStateChanged

    private void PestañasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PestañasMouseClicked

        Plantilla ventana = new Plantilla();

        if (Pestañas.getSelectedIndex() == Pestañas.getComponentCount() - 1) {
            int Pestaña = Pestañas.getComponentCount();
            for (int i = 0; i < Pestañas.getComponentCount(); i++) {
                if ("+".equals(Pestañas.getTitleAt(i))) {
                    //    Pestañas.removeTabAt(i);
                    Pestañas.setTitleAt(i, "Pagina " + Pestaña);
                }
            }
            
            Pestañas.addTab("Pagina " + Pestaña, ventana);
   
            Pestañas.setSelectedIndex(Pestañas.getComponentCount() - 1);
            Pestañas.addTab("+", ventana);

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_PestañasMouseClicked

    private void PestañasComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_PestañasComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_PestañasComponentHidden

    private void EntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EntradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EntradaActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
 

        try {
            if (historial.isEmpty()) {
                conthist = 0;
            } else {
                conthist += 1;
            }
            Historial newhist = new Historial();
            
            MostrarPagina.repaint();
            
            pintar.removeAll();
            pintar.repaint();
            
            MostrarPagina.removeAll();
            String entrada = "C:\\HTMLEntrada.txt";
            newhist.Historial(conthist, entrada);            
            historial.add(newhist);
            LeerArchivo leer = new LeerArchivo();
            String comp = leer.LeerArchivo(entrada);
            
            RecorrerArbol g = new RecorrerArbol();
            
            Lexico lexico = new Lexico(new StringReader(comp));
            //crear el sintactico
            Sintactico parser = new Sintactico(lexico);
            try {
                parser.parse();
                System.out.println("Total: " + g.tamañoarbol(1, parser.raiz));
                
                int[] posicion = new int[6];
                posicion[0] = 0;
                posicion[1] = 0;

                //g.Analizar(comp, MostrarPagina, (JTabbedPane) this.getParent(),lista); 
                pintar.setSize(MostrarPagina.getWidth(), MostrarPagina.getHeight());
                posicion = g.Analizar(comp, pintar, Pestañas, lista, posicion);
                 // MemoriaCSS(lista);
                pintar.setPreferredSize(new Dimension(posicion[4], posicion[5]));
                pintar.repaint();

                /*Iterator<String> nombreIterator = Cosas.iterator();
            while (nombreIterator.hasNext()) {
                String elemento = nombreIterator.next();
                System.out.print(elemento + "\n");
            }*/
                añadirpintar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                añadirpintar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                //  scrollPane.setBounds(0,0,MostrarPagina.getPreferredSize());
                //  scrollPane.setBounds(new Rectangle(MostrarPagina.getPreferredSize()));
                
                //añadirpintar.setBackground(Color.WHITE);
                añadirpintar.setPreferredSize(MostrarPagina.getSize());
                
                añadirpintar.setViewportView(pintar);
                
                añadirpintar.setBounds(0, 0, pintar.getWidth(), pintar.getHeight());
                MostrarPagina.add(añadirpintar);
                //MostrarPagina.add(scrollPane);
                 //MemoriaCSS(lista);
               
                 //System.out.println(Cosas.size());
            } catch (Exception ex) {
                Logger.getLogger(UsacWeb.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception e) {
        }

        
    
        //String entrada=Entrada.getText();

       
        
        
        
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
for(int i=0;i<=historial.size()-1;i++){
        System.out.println("index: "+historial.get(i).index+", ubicacion: "+historial.get(i).ubicacion);
}
// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton15ActionPerformed

    private void Entrada2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Entrada2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Entrada2ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UsacWeb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UsacWeb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UsacWeb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsacWeb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UsacWeb().setVisible(true);
                
             
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Entrada;
    private javax.swing.JTextField Entrada2;
    private javax.swing.JPanel MostrarPagina;
    private javax.swing.JPanel MostrarPagina2;
    private javax.swing.JTabbedPane Pestañas;
    private javax.swing.JPanel Plantilla;
    private javax.swing.JPanel Plantilla2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar5;
    private javax.swing.JToolBar jToolBar6;
    // End of variables declaration//GEN-END:variables
}
