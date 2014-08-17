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
import simMPLS.scenario.TLERANode;
import simMPLS.scenario.TTopology;
import simMPLS.ui.simulator.JPanelDisenio;
import simMPLS.ui.utils.TImagesBroker;

/**
 * Esta clase implementa una ventana que nos permite configurar un nodo LER
 * @author Administrador<B>Manuel Dom�nguez Dorado</B><br><A
 * href="mailto:ingeniero@ManoloDominguez.com">ingeniero@ManoloDominguez.com</A><br><A href="http://www.ManoloDominguez.com" target="_blank">http://www.ManoloDominguez.com</A>
 * @version 1.0
 */
public class JVentanaLERA extends javax.swing.JDialog {
    
    /**
     * Este m�todo crea una nueva instancia de JVentanaconfigLERA
     * @param t Topolog�a dentro del a cual se encuentra insertado el LER que queremos
     * configurar.
     * @param pad Panel de dise�o dentro del cual estamos dise�ando el LER que queremos
     * configurar.
     * @param di Dispensador de im�genes global de la aplicaci�n.
     * @param parent Ventana padre dentro de la cual se ubicar� esta ventana de tipo JVentanaLER
     * @param modal TRUE indica que la ventana impedir� que se pueda seleccionar nada de la interfaz
     * de usuario hasta que se cierre. FALSE indica que esto no es asi.
     * @since 1.0
     */
    public JVentanaLERA(TTopology t, JPanelDisenio pad, TImagesBroker di, java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        ventanaPadre = parent;
        dispensadorDeImagenes = di;
        pd = pad;
        topo = t;
        initComponents();
        initComponents2();
    }
    
    /**
     * Este m�todo terminar� de configurar aspectos de la clase que no han podido ser
     * definidos en el constructor.
     * @since 1.0
     */
    public void initComponents2() {
        panelCoordenadas.ponerPanelOrigen(pd);
        java.awt.Dimension tamFrame=this.getSize();
        java.awt.Dimension tamPadre=ventanaPadre.getSize();
        setLocation((tamPadre.width-tamFrame.width)/2, (tamPadre.height-tamFrame.height)/2);
        configLERA=null;
        coordenadaX.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("JVentanaLER.X=") + panelCoordenadas.obtenerXReal());
        coordenadaY.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("JVentanaLER.Y=") + panelCoordenadas.obtenerYReal());
        BKUPMostrarNombre = true;
        BKUPNombre = "";
        BKUPPotencia = 0;
        BKUPTamBuffer = 0;
        reconfigurando = false;
        BKUPGenerarEstadisticas = false;
        this.selectorSencilloCaracteristicas.removeAllItems();
        this.selectorSencilloCaracteristicas.addItem(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("JVentanaLERA.Personalized_LERA"));
        this.selectorSencilloCaracteristicas.addItem(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("JVentanaLERA.Very_low_range_LERA"));
        this.selectorSencilloCaracteristicas.addItem(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("JVentanaLERA.Low_range_LERA"));
        this.selectorSencilloCaracteristicas.addItem(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("JVentanaLERA.Medium_range_LERA"));
        this.selectorSencilloCaracteristicas.addItem(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("JVentanaLERA.High_range_LERA"));
        this.selectorSencilloCaracteristicas.addItem(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("JVentanaLERA.Very_high_range_LERA"));
        this.selectorSencilloCaracteristicas.setSelectedIndex(0);
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
        iconoLER = new javax.swing.JLabel();
        etiquetaNombre = new javax.swing.JLabel();
        nombreNodo = new javax.swing.JTextField();
        panelPosicion = new javax.swing.JPanel();
        coordenadaX = new javax.swing.JLabel();
        coordenadaY = new javax.swing.JLabel();
        panelCoordenadas = new simMPLS.ui.dialogs.JPanelCoordenadas();
        verNombre = new javax.swing.JCheckBox();
        panelRapido = new javax.swing.JPanel();
        selectorDeGenerarEstadisticasSencillo = new javax.swing.JCheckBox();
        iconoEnlace1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        selectorSencilloCaracteristicas = new javax.swing.JComboBox();
        panelAvanzado = new javax.swing.JPanel();
        selectorDeGenerarEstadisticasAvanzado = new javax.swing.JCheckBox();
        iconoEnlace2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        selectorDePotenciaDeConmutacion = new javax.swing.JSlider();
        etiquetaPotencia = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        selectorDeTamanioBuffer = new javax.swing.JSlider();
        etiquetaMemoriaBuffer = new javax.swing.JLabel();
        selectorDeTamanioDMGP = new javax.swing.JSlider();
        etiquetaMemoriaDMGP = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        panelBotones = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        setTitle(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaLERA.titulo"));
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

        iconoLER.setIcon(dispensadorDeImagenes.obtenerIcono(TImagesBroker.LERA));
        iconoLER.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("LERA.Descripcion"));
        panelGeneral.add(iconoLER, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 20, 335, -1));

        etiquetaNombre.setFont(new java.awt.Font("Dialog", 0, 12));
        etiquetaNombre.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaLERA.etiquetaNombre"));
        panelGeneral.add(etiquetaNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 80, 120, -1));

        panelGeneral.add(nombreNodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 105, 125, -1));

        panelPosicion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelPosicion.setBorder(new javax.swing.border.TitledBorder(null, java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaLER.etiquetaGrupo"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12)));
        coordenadaX.setFont(new java.awt.Font("Dialog", 0, 12));
        coordenadaX.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaLER.X="));
        panelPosicion.add(coordenadaX, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, -1, -1));

        coordenadaY.setFont(new java.awt.Font("Dialog", 0, 12));
        coordenadaY.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaLER.Y="));
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
        verNombre.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaLER.verNombre"));
        panelGeneral.add(verNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 135, -1, -1));

        panelPestanias.addTab(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaLER.tabs.General"), panelGeneral);

        panelRapido.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        selectorDeGenerarEstadisticasSencillo.setFont(new java.awt.Font("Dialog", 0, 12));
        selectorDeGenerarEstadisticasSencillo.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaLERA.GenerarEstadisticas"));
        selectorDeGenerarEstadisticasSencillo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clicEnGenerarEstadisticasSencillo(evt);
            }
        });

        panelRapido.add(selectorDeGenerarEstadisticasSencillo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, -1, -1));

        iconoEnlace1.setIcon(dispensadorDeImagenes.obtenerIcono(TImagesBroker.ASISTENTE));
        iconoEnlace1.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaLERA.ConfiguracionRapida"));
        panelRapido.add(iconoEnlace1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 20, 335, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaLERA.CaracteristicasDelLER"));
        panelRapido.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 160, -1));

        selectorSencilloCaracteristicas.setFont(new java.awt.Font("Dialog", 0, 12));
        selectorSencilloCaracteristicas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Personalized", "Very low cost LER", "Low cost LER", "Medium cost LER", "Expensive LER", "Very expensive LER" }));
        selectorSencilloCaracteristicas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cliEnSelectorSencilloCaracteristicas(evt);
            }
        });

        panelRapido.add(selectorSencilloCaracteristicas, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, -1, -1));

        panelPestanias.addTab(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaLER.tabs.Fast"), panelRapido);

        panelAvanzado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        selectorDeGenerarEstadisticasAvanzado.setFont(new java.awt.Font("Dialog", 0, 12));
        selectorDeGenerarEstadisticasAvanzado.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaLERA.GenerarEstadisticas"));
        selectorDeGenerarEstadisticasAvanzado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clicEnGenerarEstadisticasAvanzada(evt);
            }
        });

        panelAvanzado.add(selectorDeGenerarEstadisticasAvanzado, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, -1));

        iconoEnlace2.setIcon(dispensadorDeImagenes.obtenerIcono(TImagesBroker.AVANZADA));
        iconoEnlace2.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaLERA.ConfiguracionAvanzada"));
        panelAvanzado.add(iconoEnlace2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 20, 335, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaLER.PotenciaDeConmutacion"));
        panelAvanzado.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 140, -1));

        selectorDePotenciaDeConmutacion.setMajorTickSpacing(1000);
        selectorDePotenciaDeConmutacion.setMaximum(10240);
        selectorDePotenciaDeConmutacion.setMinimum(1);
        selectorDePotenciaDeConmutacion.setMinorTickSpacing(100);
        selectorDePotenciaDeConmutacion.setValue(1);
        selectorDePotenciaDeConmutacion.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                selectorDePotenciadeConmutacionCambiado(evt);
            }
        });

        panelAvanzado.add(selectorDePotenciaDeConmutacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 90, 130, 20));

        etiquetaPotencia.setFont(new java.awt.Font("Dialog", 0, 10));
        etiquetaPotencia.setForeground(new java.awt.Color(102, 102, 102));
        etiquetaPotencia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        etiquetaPotencia.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaLER.1_Mbps"));
        panelAvanzado.add(etiquetaPotencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 70, 20));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaLER.TamanioDelBufferDeEntrada"));
        panelAvanzado.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 180, -1));

        selectorDeTamanioBuffer.setMajorTickSpacing(50);
        selectorDeTamanioBuffer.setMaximum(1024);
        selectorDeTamanioBuffer.setMinimum(1);
        selectorDeTamanioBuffer.setMinorTickSpacing(100);
        selectorDeTamanioBuffer.setValue(1);
        selectorDeTamanioBuffer.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                selectorDeTamanioBufferCambiado(evt);
            }
        });

        panelAvanzado.add(selectorDeTamanioBuffer, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 100, 20));

        etiquetaMemoriaBuffer.setFont(new java.awt.Font("Dialog", 0, 10));
        etiquetaMemoriaBuffer.setForeground(new java.awt.Color(102, 102, 102));
        etiquetaMemoriaBuffer.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        etiquetaMemoriaBuffer.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaLER.1_MB"));
        panelAvanzado.add(etiquetaMemoriaBuffer, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 60, 20));

        selectorDeTamanioDMGP.setMajorTickSpacing(50);
        selectorDeTamanioDMGP.setMaximum(102400);
        selectorDeTamanioDMGP.setMinimum(1);
        selectorDeTamanioDMGP.setMinorTickSpacing(100);
        selectorDeTamanioDMGP.setValue(1);
        selectorDeTamanioDMGP.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                selectorDeTamanioDMGPCambiado(evt);
            }
        });

        panelAvanzado.add(selectorDeTamanioDMGP, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 120, 20));

        etiquetaMemoriaDMGP.setFont(new java.awt.Font("Dialog", 0, 10));
        etiquetaMemoriaDMGP.setForeground(new java.awt.Color(102, 102, 102));
        etiquetaMemoriaDMGP.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        etiquetaMemoriaDMGP.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("JVentanaLERA.1KB"));
        panelAvanzado.add(etiquetaMemoriaDMGP, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 70, 20));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 12));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("JVentanaLERA.DMGP_size"));
        panelAvanzado.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 150, -1));

        panelPestanias.addTab(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaLER.tabs.Advanced"), panelAvanzado);

        panelPrincipal.add(panelPestanias, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 370, 240));

        panelBotones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setFont(new java.awt.Font("Dialog", 0, 12));
        jButton2.setIcon(dispensadorDeImagenes.obtenerIcono(TImagesBroker.ACEPTAR));
        jButton2.setMnemonic(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaLER.botones.mne.Aceptar").charAt(0));
        jButton2.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaLER.boton.Ok"));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clicEnAceptar(evt);
            }
        });

        panelBotones.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 115, -1));

        jButton3.setFont(new java.awt.Font("Dialog", 0, 12));
        jButton3.setIcon(dispensadorDeImagenes.obtenerIcono(TImagesBroker.CANCELAR));
        jButton3.setMnemonic(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaLER.botones.mne.Cancelar").charAt(0));
        jButton3.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaLER.boton.Cancel"));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clicEnCancelar(evt);
            }
        });

        panelBotones.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 15, 115, -1));

        panelPrincipal.add(panelBotones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 400, 50));

        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 310));

        pack();
    }//GEN-END:initComponents

    private void selectorDeTamanioDMGPCambiado(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_selectorDeTamanioDMGPCambiado
        this.etiquetaMemoriaDMGP.setText(""+this.selectorDeTamanioDMGP.getValue()+" "+java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("JVentanaLERA._MB."));
    }//GEN-LAST:event_selectorDeTamanioDMGPCambiado

    private void cliEnSelectorSencilloCaracteristicas(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cliEnSelectorSencilloCaracteristicas
        int opcionSeleccionada = this.selectorSencilloCaracteristicas.getSelectedIndex();
        if (opcionSeleccionada == 0) {
            // No se hace nada
            this.selectorSencilloCaracteristicas.setSelectedIndex(0);
        } else if (opcionSeleccionada == 1) {
            this.selectorDePotenciaDeConmutacion.setValue(1);
            this.selectorDeTamanioBuffer.setValue(1);
            this.selectorDeTamanioDMGP.setValue(1);
            this.selectorSencilloCaracteristicas.setSelectedIndex(1);
        } else if (opcionSeleccionada == 2) {
            this.selectorDePotenciaDeConmutacion.setValue(2560);
            this.selectorDeTamanioBuffer.setValue(256);
            this.selectorDeTamanioDMGP.setValue(2);
            this.selectorSencilloCaracteristicas.setSelectedIndex(2);
        } else if (opcionSeleccionada == 3) {
            this.selectorDePotenciaDeConmutacion.setValue(5120);
            this.selectorDeTamanioBuffer.setValue(512);
            this.selectorDeTamanioDMGP.setValue(3);
            this.selectorSencilloCaracteristicas.setSelectedIndex(3);
        } else if (opcionSeleccionada == 4) {
            this.selectorDePotenciaDeConmutacion.setValue(7680);
            this.selectorDeTamanioBuffer.setValue(768);
            this.selectorDeTamanioDMGP.setValue(4);
            this.selectorSencilloCaracteristicas.setSelectedIndex(4);
        } else if (opcionSeleccionada == 5) {
            this.selectorDePotenciaDeConmutacion.setValue(10240);
            this.selectorDeTamanioBuffer.setValue(1024);
            this.selectorDeTamanioDMGP.setValue(5);
            this.selectorSencilloCaracteristicas.setSelectedIndex(5);
        }
    }//GEN-LAST:event_cliEnSelectorSencilloCaracteristicas

    private void selectorDeTamanioBufferCambiado(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_selectorDeTamanioBufferCambiado
        this.selectorSencilloCaracteristicas.setSelectedIndex(0);
        this.etiquetaMemoriaBuffer.setText(this.selectorDeTamanioBuffer.getValue() + " " + java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaLER.MB"));
    }//GEN-LAST:event_selectorDeTamanioBufferCambiado

    private void selectorDePotenciadeConmutacionCambiado(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_selectorDePotenciadeConmutacionCambiado
        this.selectorSencilloCaracteristicas.setSelectedIndex(0);
        this.etiquetaPotencia.setText(this.selectorDePotenciaDeConmutacion.getValue() + " " + java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaLER.Mbps."));
    }//GEN-LAST:event_selectorDePotenciadeConmutacionCambiado

    private void clicEnGenerarEstadisticasAvanzada(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clicEnGenerarEstadisticasAvanzada
        this.selectorDeGenerarEstadisticasSencillo.setSelected(this.selectorDeGenerarEstadisticasAvanzado.isSelected());
    }//GEN-LAST:event_clicEnGenerarEstadisticasAvanzada

    private void clicEnGenerarEstadisticasSencillo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clicEnGenerarEstadisticasSencillo
        this.selectorDeGenerarEstadisticasAvanzado.setSelected(this.selectorDeGenerarEstadisticasSencillo.isSelected());
    }//GEN-LAST:event_clicEnGenerarEstadisticasSencillo
    
private void clicEnCancelar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clicEnCancelar
    if (reconfigurando) {
        configLERA.ponerMostrarNombre(BKUPMostrarNombre);
        configLERA.ponerNombre(BKUPNombre);
        configLERA.ponerBienConfigurado(true);
        configLERA.ponerTamanioBuffer(BKUPTamBuffer);
        configLERA.ponerPotenciaEnMb(BKUPPotencia);
        configLERA.ponerEstadisticas(BKUPGenerarEstadisticas);
        configLERA.ponerTamanioDMGPEnKB(BKUPTamanioDMGP);
        reconfigurando = false;
    } else {
        configLERA.ponerBienConfigurado(false);
    }
    this.setVisible(false);
    this.dispose();
}//GEN-LAST:event_clicEnCancelar

private void clicEnAceptar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clicEnAceptar
    configLERA.ponerBienConfigurado(true);
    if (!this.reconfigurando){
        configLERA.ponerPosicion(new Point(panelCoordenadas.obtenerXReal(),panelCoordenadas.obtenerYReal()));
    }
    configLERA.ponerTamanioDMGPEnKB(this.selectorDeTamanioDMGP.getValue());
    configLERA.ponerTamanioBuffer(this.selectorDeTamanioBuffer.getValue());
    configLERA.ponerPotenciaEnMb(this.selectorDePotenciaDeConmutacion.getValue());
    configLERA.ponerEstadisticas(this.selectorDeGenerarEstadisticasSencillo.isSelected());
    configLERA.ponerNombre(nombreNodo.getText());
    configLERA.ponerMostrarNombre(verNombre.isSelected());
    configLERA.ponerEstadisticas(this.selectorDeGenerarEstadisticasSencillo.isSelected());
    int error = configLERA.comprobar(topo, this.reconfigurando);
    if (error != TLERANode.CORRECTA) {
        JVentanaAdvertencia va = new JVentanaAdvertencia(ventanaPadre, true, dispensadorDeImagenes);
        va.mostrarMensaje(configLERA.obtenerMensajeError(error));
        va.show();
    } else {
        this.setVisible(false);
        this.dispose();
    }
}//GEN-LAST:event_clicEnAceptar

private void clicEnPanelCoordenadas(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clicEnPanelCoordenadas
    if (evt.getButton() == MouseEvent.BUTTON1) {
        panelCoordenadas.ponerCoordenadasReducidas(evt.getPoint());
        coordenadaX.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaconfigLERA.X=_") + panelCoordenadas.obtenerXReal());
        coordenadaY.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaconfigLERA.Y=_") + panelCoordenadas.obtenerYReal());
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
        configLERA.ponerBienConfigurado(false);
        dispose();
    }//GEN-LAST:event_closeDialog
    
    /**
     * Este m�todo permite cargar en la ventana la configuraci�n actual del LER.
     * @since 1.0
     * @param tnlera El nodo LER que queremos configurar.
     * @param recfg TRUE indica que estamos reconfigurando el LER. FALSE indica que el LER se ha
     * insertado nuevo en la topolog�a.
     */
    public void ponerConfiguracion(TLERANode tnlera, boolean recfg) {
        configLERA = tnlera;
        reconfigurando = recfg;
        if (reconfigurando) {
            this.panelCoordenadas.setEnabled(false);
            this.panelCoordenadas.setToolTipText(null);

            BKUPGenerarEstadisticas = tnlera.obtenerEstadisticas();
            BKUPMostrarNombre = tnlera.obtenerMostrarNombre();
            BKUPNombre = tnlera.obtenerNombre();
            BKUPPotencia = tnlera.obtenerPotenciaEnMb();
            BKUPTamBuffer = tnlera.obtenerTamanioBuffer();
            BKUPTamanioDMGP = tnlera.obtenerTamanioDMGPEnKB();

            this.selectorDeTamanioDMGP.setValue(this.BKUPTamanioDMGP);
            this.selectorDeGenerarEstadisticasAvanzado.setSelected(BKUPGenerarEstadisticas);
            this.selectorDeGenerarEstadisticasSencillo.setSelected(BKUPGenerarEstadisticas);
            this.selectorDePotenciaDeConmutacion.setValue(BKUPPotencia);
            this.selectorDeTamanioBuffer.setValue(BKUPTamBuffer);
            this.nombreNodo.setText(BKUPNombre);
            this.verNombre.setSelected(BKUPMostrarNombre);
        }
    }
    
    private TImagesBroker dispensadorDeImagenes;
    private Frame ventanaPadre;
    private JPanelDisenio pd;
    private TLERANode configLERA;
    private TTopology topo;
    
    private boolean BKUPMostrarNombre;
    private String BKUPNombre;
    private int BKUPPotencia;
    private int BKUPTamBuffer;
    private boolean BKUPGenerarEstadisticas;
    private int BKUPTamanioDMGP;

    private boolean reconfigurando;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel coordenadaX;
    private javax.swing.JLabel coordenadaY;
    private javax.swing.JLabel etiquetaMemoriaBuffer;
    private javax.swing.JLabel etiquetaMemoriaDMGP;
    private javax.swing.JLabel etiquetaNombre;
    private javax.swing.JLabel etiquetaPotencia;
    private javax.swing.JLabel iconoEnlace1;
    private javax.swing.JLabel iconoEnlace2;
    private javax.swing.JLabel iconoLER;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField nombreNodo;
    private javax.swing.JPanel panelAvanzado;
    private javax.swing.JPanel panelBotones;
    private simMPLS.ui.dialogs.JPanelCoordenadas panelCoordenadas;
    private javax.swing.JPanel panelGeneral;
    private javax.swing.JTabbedPane panelPestanias;
    private javax.swing.JPanel panelPosicion;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelRapido;
    private javax.swing.JCheckBox selectorDeGenerarEstadisticasAvanzado;
    private javax.swing.JCheckBox selectorDeGenerarEstadisticasSencillo;
    private javax.swing.JSlider selectorDePotenciaDeConmutacion;
    private javax.swing.JSlider selectorDeTamanioBuffer;
    private javax.swing.JSlider selectorDeTamanioDMGP;
    private javax.swing.JComboBox selectorSencilloCaracteristicas;
    private javax.swing.JCheckBox verNombre;
    // End of variables declaration//GEN-END:variables
    
}
