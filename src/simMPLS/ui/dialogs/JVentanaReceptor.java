/* 
 * Copyright (C) 2014 Manuel Domínguez-Dorado <ingeniero@manolodominguez.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package simMPLS.ui.dialogs;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import simMPLS.scenario.TReceiverNode;
import simMPLS.scenario.TTopology;
import simMPLS.ui.simulator.JPanelDisenio;
import simMPLS.ui.utils.TImagesBroker;

/**
 * Esta clase implementa una ventana que permite al usuario configurar todos los
 * aspectos de un nodo receptor.
 * @author <B>Manuel Dom�nguez Dorado</B><br><A
 * href="mailto:ingeniero@ManoloDominguez.com">ingeniero@ManoloDominguez.com</A><br><A href="http://www.ManoloDominguez.com" target="_blank">http://www.ManoloDominguez.com</A>
 * @version 1.0
 */
public class JVentanaReceptor extends javax.swing.JDialog {

    /**
     * Crea una nueva instancia de JVentanaReceptor
     * @since 1.0
     * @param t Topolog�a dentro de la cual se encuentra el nodo receptor que se va a configurar.
     * @param pad Panel de dise�o en el cual se est� dise�ando el nodo receptor.
     * @param di Dispensador de im�genes com�n a todo el programa.
     * @param parent Ventana padre dentro de la cual se va a abrir la ventana de configuraci�n del
     * receptor.
     * @param modal TRUE indica que la interfaz quedar� deshabilitada hasta que se cierre la ventana
     * de configuraci�n del nodo receptor. FALSE indica que no es as�.
     */
    public JVentanaReceptor(TTopology t, JPanelDisenio pad, TImagesBroker di, java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        ventanaPadre = parent;
        dispensadorDeImagenes = di;
        pd = pad;
        topo = t;
        initComponents();
        initComponents2();
    }

    /**
     * Este m�todo configura los componentes que no hayan quedado del todo configurados
     * en el constructor.
     * @since 1.0
     */    
    public void initComponents2() {
        panelCoordenadas.ponerPanelOrigen(pd);
        java.awt.Dimension tamFrame=this.getSize();
        java.awt.Dimension tamPadre=ventanaPadre.getSize();
        setLocation((tamPadre.width-tamFrame.width)/2, (tamPadre.height-tamFrame.height)/2);
        configReceptor = null;
        coordenadaX.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaEmisor.X=_") + panelCoordenadas.obtenerXReal());
        coordenadaY.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaEmisor.Y=_") + panelCoordenadas.obtenerYReal());
        BKUPMostrarNombre = true;
        BKUPNombre = "";
        reconfigurando = false;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        panelPrincipal = new javax.swing.JPanel();
        panelPestanias = new javax.swing.JTabbedPane();
        panelGeneral = new javax.swing.JPanel();
        iconoReceptor = new javax.swing.JLabel();
        etiquetaNombre = new javax.swing.JLabel();
        nombreNodo = new javax.swing.JTextField();
        panelPosicion = new javax.swing.JPanel();
        coordenadaX = new javax.swing.JLabel();
        coordenadaY = new javax.swing.JLabel();
        panelCoordenadas = new simMPLS.ui.dialogs.JPanelCoordenadas();
        verNombre = new javax.swing.JCheckBox();
        panelRapido = new javax.swing.JPanel();
        iconoEnlace1 = new javax.swing.JLabel();
        selectorGenerarEstadisticaFacil = new javax.swing.JCheckBox();
        panelAvanzado = new javax.swing.JPanel();
        iconoEnlace2 = new javax.swing.JLabel();
        selectorGenerarEstadisticaAvanzada = new javax.swing.JCheckBox();
        panelBotones = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        setTitle(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaReceptor.titulo"));
        setModal(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        panelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelPestanias.setFont(new java.awt.Font("Dialog", 0, 12));
        panelGeneral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        iconoReceptor.setIcon(dispensadorDeImagenes.obtenerIcono(TImagesBroker.RECEPTOR));
        iconoReceptor.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaReceptor.descripcion"));
        panelGeneral.add(iconoReceptor, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 20, 335, -1));

        etiquetaNombre.setFont(new java.awt.Font("Dialog", 0, 12));
        etiquetaNombre.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaReceptor.etiquetaNombre"));
        panelGeneral.add(etiquetaNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 80, 120, -1));

        panelGeneral.add(nombreNodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 105, 125, -1));

        panelPosicion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelPosicion.setBorder(new javax.swing.border.TitledBorder(null, java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaReceptor.titulogrupo"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12)));
        coordenadaX.setFont(new java.awt.Font("Dialog", 0, 12));
        coordenadaX.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaReceptor.X=_"));
        panelPosicion.add(coordenadaX, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, -1, -1));

        coordenadaY.setFont(new java.awt.Font("Dialog", 0, 12));
        coordenadaY.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaReceptor.Y=_"));
        panelPosicion.add(coordenadaY, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        panelCoordenadas.setBackground(new java.awt.Color(255, 255, 255));
        panelCoordenadas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clicEnPanelCoordenadas(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ratonEntraEnPanelCoordenadas(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ratonSaleDePanelCoordenadas(evt);
            }
        });

        panelPosicion.add(panelCoordenadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 25, 130, 70));

        panelGeneral.add(panelPosicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 75, 180, 125));

        verNombre.setFont(new java.awt.Font("Dialog", 0, 12));
        verNombre.setSelected(true);
        verNombre.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaReceptor.verNombre"));
        panelGeneral.add(verNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 135, -1, -1));

        panelPestanias.addTab(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaReceptor.tab.General"), panelGeneral);

        panelRapido.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        iconoEnlace1.setIcon(dispensadorDeImagenes.obtenerIcono(TImagesBroker.ASISTENTE));
        iconoEnlace1.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("JVentanaReceptor.configuracionSencilla"));
        panelRapido.add(iconoEnlace1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 20, 335, -1));

        selectorGenerarEstadisticaFacil.setFont(new java.awt.Font("Dialog", 0, 12));
        selectorGenerarEstadisticaFacil.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("JVentanaReceptor.generarEstadisticas"));
        selectorGenerarEstadisticaFacil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clicEnGenerarEstadisticaFacil(evt);
            }
        });

        panelRapido.add(selectorGenerarEstadisticaFacil, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 125, -1, -1));

        panelPestanias.addTab(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaReceptor.tab.Fast"), panelRapido);

        panelAvanzado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        iconoEnlace2.setIcon(dispensadorDeImagenes.obtenerIcono(TImagesBroker.AVANZADA));
        iconoEnlace2.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("JVentanaReceptor.configuracionAvanzada"));
        panelAvanzado.add(iconoEnlace2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 20, 335, -1));

        selectorGenerarEstadisticaAvanzada.setFont(new java.awt.Font("Dialog", 0, 12));
        selectorGenerarEstadisticaAvanzada.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("JVentanaReceptor.GenerEstadisticas"));
        selectorGenerarEstadisticaAvanzada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clicEnGenerarEstadisticaAvanzada(evt);
            }
        });

        panelAvanzado.add(selectorGenerarEstadisticaAvanzada, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 125, -1, -1));

        panelPestanias.addTab(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaReceptor.tab.Advanced"), panelAvanzado);

        panelPrincipal.add(panelPestanias, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 370, 240));

        panelBotones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setFont(new java.awt.Font("Dialog", 0, 12));
        jButton2.setIcon(dispensadorDeImagenes.obtenerIcono(TImagesBroker.ACEPTAR));
        jButton2.setMnemonic(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaReceptor.botones.mne.Aceptar").charAt(0));
        jButton2.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaReceptor.boton.Ok"));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clicEnAceptar(evt);
            }
        });

        panelBotones.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 105, -1));

        jButton3.setFont(new java.awt.Font("Dialog", 0, 12));
        jButton3.setIcon(dispensadorDeImagenes.obtenerIcono(TImagesBroker.CANCELAR));
        jButton3.setMnemonic(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaReceptor.botones.mne.Cancelar").charAt(0));
        jButton3.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaReceptor.boton.Cancel"));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clicEnCancelar(evt);
            }
        });

        panelBotones.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 15, 105, -1));

        panelPrincipal.add(panelBotones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 255, 400, 55));

        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 310));

        pack();
    }//GEN-END:initComponents

private void clicEnGenerarEstadisticaAvanzada(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clicEnGenerarEstadisticaAvanzada
    this.selectorGenerarEstadisticaFacil.setSelected(this.selectorGenerarEstadisticaAvanzada.isSelected());
}//GEN-LAST:event_clicEnGenerarEstadisticaAvanzada

private void clicEnGenerarEstadisticaFacil(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clicEnGenerarEstadisticaFacil
    this.selectorGenerarEstadisticaAvanzada.setSelected(this.selectorGenerarEstadisticaFacil.isSelected());
}//GEN-LAST:event_clicEnGenerarEstadisticaFacil

private void clicEnCancelar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clicEnCancelar
    if (reconfigurando) {
        configReceptor.ponerMostrarNombre(BKUPMostrarNombre);
        configReceptor.ponerNombre(BKUPNombre);
        configReceptor.ponerBienConfigurado(true);
        reconfigurando = false;
    } else {
        configReceptor.ponerBienConfigurado(false);
    }
    this.setVisible(false);
    this.dispose();
}//GEN-LAST:event_clicEnCancelar

private void clicEnAceptar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clicEnAceptar
    configReceptor.ponerBienConfigurado(true);
    if (!this.reconfigurando){
        configReceptor.ponerPosicion(new Point(panelCoordenadas.obtenerXReal(),panelCoordenadas.obtenerYReal()));
    }
    configReceptor.ponerNombre(nombreNodo.getText());
    configReceptor.ponerMostrarNombre(verNombre.isSelected());
    configReceptor.ponerEstadisticas(this.selectorGenerarEstadisticaAvanzada.isSelected());
    int error = configReceptor.comprobar(topo, this.reconfigurando);
    if (error != TReceiverNode.CORRECTA) {
        JVentanaAdvertencia va = new JVentanaAdvertencia(ventanaPadre, true, dispensadorDeImagenes);
        va.mostrarMensaje(configReceptor.obtenerMensajeError(error));
        va.show();
    } else {
        this.setVisible(false);
        this.dispose();
    }
}//GEN-LAST:event_clicEnAceptar

private void clicEnPanelCoordenadas(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clicEnPanelCoordenadas
    if (evt.getButton() == MouseEvent.BUTTON1) {
        panelCoordenadas.ponerCoordenadasReducidas(evt.getPoint());
        coordenadaX.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaEmisor.X=_") + panelCoordenadas.obtenerXReal());
        coordenadaY.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaEmisor.Y=_") + panelCoordenadas.obtenerYReal());
        panelCoordenadas.repaint();
    }
}//GEN-LAST:event_clicEnPanelCoordenadas

private void ratonSaleDePanelCoordenadas(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ratonSaleDePanelCoordenadas
    this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
}//GEN-LAST:event_ratonSaleDePanelCoordenadas

private void ratonEntraEnPanelCoordenadas(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ratonEntraEnPanelCoordenadas
    this.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
}//GEN-LAST:event_ratonEntraEnPanelCoordenadas

    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        configReceptor.ponerBienConfigurado(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    /**
     * Este m�todo configura la ventana de configuraci�n del receptor con los valores
     * que el receptor tenga ya activos.
     * @since 1.0
     * @param tnr Nodo receptor que se desea configurar.
     * @param recfg TRUE indica que es una reconfiguraci�n del nodo receptor. FALSE indica que el
     * nodo est� siendo insertado por primera vez.
     */    
    public void ponerConfiguracion(TReceiverNode tnr, boolean recfg) {
        configReceptor = tnr;
        reconfigurando = recfg;
        if (reconfigurando) {
            this.panelCoordenadas.setEnabled(false);
            this.panelCoordenadas.setToolTipText(null);

            BKUPGenerarEstadisticas = tnr.obtenerEstadisticas();
            BKUPMostrarNombre = tnr.obtenerMostrarNombre();
            BKUPNombre = tnr.obtenerNombre();

            this.nombreNodo.setText(BKUPNombre);
            this.verNombre.setSelected(BKUPMostrarNombre);
            this.selectorGenerarEstadisticaAvanzada.setSelected(BKUPGenerarEstadisticas);
            this.selectorGenerarEstadisticaFacil.setSelected(BKUPGenerarEstadisticas);
        }
    }

    private TImagesBroker dispensadorDeImagenes;
    private Frame ventanaPadre;
    private JPanelDisenio pd;
    private TReceiverNode configReceptor;
    private TTopology topo;
    
    private boolean BKUPMostrarNombre;
    private String BKUPNombre;
    private boolean BKUPGenerarEstadisticas;

    private boolean reconfigurando;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel coordenadaX;
    private javax.swing.JLabel coordenadaY;
    private javax.swing.JLabel etiquetaNombre;
    private javax.swing.JLabel iconoEnlace1;
    private javax.swing.JLabel iconoEnlace2;
    private javax.swing.JLabel iconoReceptor;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JTextField nombreNodo;
    private javax.swing.JPanel panelAvanzado;
    private javax.swing.JPanel panelBotones;
    private simMPLS.ui.dialogs.JPanelCoordenadas panelCoordenadas;
    private javax.swing.JPanel panelGeneral;
    private javax.swing.JTabbedPane panelPestanias;
    private javax.swing.JPanel panelPosicion;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelRapido;
    private javax.swing.JCheckBox selectorGenerarEstadisticaAvanzada;
    private javax.swing.JCheckBox selectorGenerarEstadisticaFacil;
    private javax.swing.JCheckBox verNombre;
    // End of variables declaration//GEN-END:variables

}
