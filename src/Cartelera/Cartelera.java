package Cartelera;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Cartelera extends JFrame implements ActionListener, ItemListener {

    JPanel cartel;
    ImageIcon flash, shrek, spiderman, transformers;

    JButton aceptar, imprimir, limpiar, costear;

    JLabel  cartelera,  boleto1, previo, horap, recibo, A, N, BOL,  cart, ord;

    JTextField total, pel, numA, numN, horaprev, afo,
            montoA, montoN, precioA, precioN, Tsin, iva, nom;
    JComboBox pelicula, horario, lista;
    JTextArea ticket;

    JCheckBox adulto, niño, A2x1;

    public static void main(String[] args) {
        Cartelera c = new Cartelera();
        c.GUI();
        c.setSize(1150, 680);
        c.setVisible(true);
    }

    public void GUI() {

        // CREACION DE LA VENTANA
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("T-REX Movie");
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("t-rex1.png"));
        setIconImage(icon);


        //Fondo del panel    
        JPanel fondo = new JPanel();
        fondo.setSize(1150, 680);
        ImageIcon imageIcon = new ImageIcon("DinoF.png");
        Image image = imageIcon.getImage().getScaledInstance(1150, 680, Image.SCALE_SMOOTH);
        JLabel background = new JLabel(new ImageIcon(image));
        background.setBounds(0, 0, fondo.getWidth(), fondo.getHeight());
        add(background);
        fondo.setLayout(null);

        // LABEL ORDEN
        ord = new JLabel("ORDEN");
        add(ord);
        ord.setFont(new java.awt.Font("BankGothic Lt BT", 1, 34));
        ord.setBounds(100, 0, 350, 60);

        // LABEL CARTELERA
        cart = new JLabel("CARTELERA");
        add(cart);
        cart.setFont(new java.awt.Font("BankGothic Lt BT", 1, 34));
        cart.setBounds(400, 0, 350, 60);

        // LABEL PELICULAS
        cartelera = new JLabel("Peliculas");
        cartelera.setForeground(Color.BLACK);
        cartelera.setFont(new Font("Bookman Old Style", 1, 18));
        add(cartelera);
        cartelera.setBounds(10, 70, 100, 20);

        // OPCIONES DE LAS PELICULAS
        pelicula = new JComboBox();
        pelicula.setBackground(new Color(95, 235, 214));
        pelicula.setFont(new Font("Century Schoolbook", 1, 14));
        pelicula.setForeground(Color.BLACK);
        pelicula.addItem(" ");
        pelicula.addItem("Flash");
        pelicula.addItem("Shrek");
        pelicula.addItem("Spiderman");
        pelicula.addItem("Transformers");
        pelicula.addActionListener(this);
        add(pelicula);
        pelicula.setBounds(100, 70, 140, 20);

        // CREACION DE LAS IMAGENES
        flash = new ImageIcon("Flash.png");
        shrek = new ImageIcon("Shrek.png");
        spiderman = new ImageIcon("Spiderman.png");
        transformers = new ImageIcon("Transformers.png");

        // PANEL DEL CARTEL
        cartel = new JPanel();
        cartel.setPreferredSize(new Dimension(330, 450));
        cartel.setBackground(Color.white);
        add(cartel);
        cartel.setBounds(360, 60, 290, 410);

        // LABEL DE HORARIOS
        JLabel horarios = new JLabel("Horario");
        horarios.setForeground(Color.BLACK);
        horarios.setFont(new Font("Bookman Old Style", 1, 18));
        add(horarios);
        horarios.setBounds(10, 100, 100, 20);

        // OPCIONES DE HORARIO
        horario = new JComboBox();
        horario.setBackground(new Color(95, 235, 214));
        horario.setFont(new Font("Century Schoolbook", 1, 14));
        horario.setForeground(Color.BLACK);
        horario.addItem(" ");
        horario.addItem("2:30 pm.");
        horario.addItem("4:00 pm.");
        horario.addItem("6:10 pm.");
        horario.addItem("9:15 pm.");
        horario.addItem("11:40 pm.");
        add(horario);
        horario.setBounds(100, 100, 83, 20);
        horario.addActionListener(this);

        // LABEL DE PELICULA PREVIA
        JLabel pelv = new JLabel("Pelicula:");
        pelv.setForeground(Color.BLACK);
        pelv.setFont(new Font("Bookman Old Style", 1, 18));
        add(pelv);
        pelv.setBounds(10, 250, 100, 20);

        // TEXT PREVIO PELICULA
        pel = new JTextField(12);
        pel.setBackground(new Color(16, 254, 242));
        pel.setFont(new Font("Bookman Old Style", 1, 15));
        pel.setForeground(Color.DARK_GRAY);
        add(pel);
        pel.setBounds(93, 250, 90, 25);

        // LABEL PREVIO HORA
        horap = new JLabel("Hora:");
        horap.setForeground(Color.BLACK);
        horap.setFont(new Font("Bookman Old Style", 1, 18));
        add(horap);
        horap.setBounds(10, 280, 100, 20);

        // TEXT PREVIO HORA
        horaprev = new JTextField(12);
        horaprev.setBackground(new Color(16, 254, 242));
        horaprev.setFont(new Font("Bookman Old Style", 1, 15));
        horaprev.setForeground(Color.DARK_GRAY);
        add(horaprev);
        horaprev.setBounds(65, 280, 90, 25);

        // LABEL DE TICKET
        recibo = new JLabel("TICKET");
        add(recibo);
        recibo.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 32));
        recibo.setBounds(810, 2, 200, 50);

        // TEXT TICKET
        ticket = new JTextArea();
        JScrollPane panelDespl = new JScrollPane(ticket);
        panelDespl.setBounds(700, 60, 390, 550);
        add(panelDespl);

        // LABEL SALAS
        JLabel sala = new JLabel("Elija la sala");
        sala.setBounds(10, 110, 300, 60);
        sala.setForeground(Color.BLACK);
        sala.setFont(new Font("Bookman Old Style", 1, 18));
        sala.setVisible(true);
        add(sala);

        // OPCIONES DE SALA
        lista = new JComboBox();
        lista.setToolTipText("Seleciona");
        lista.setBackground(new Color(95, 235, 214));
        lista.setFont(new Font("Century Schoolbook", 1, 14));
        lista.setForeground(Color.BLACK);
        lista.addItem("");
        lista.addItem("Normal");
        lista.addItem("VIP");
        lista.addItem("Premium");
        lista.addActionListener(this);
        add(lista);
        lista.setBounds(130, 130, 83, 20);

//        // LABEL AFORO
        JLabel aforo = new JLabel("Sala:");
        aforo.setForeground(Color.BLACK);
        aforo.setFont(new Font("Bookman Old Style", 1, 18));
        add(aforo);
        aforo.setBounds(10, 315, 100, 20);

        // TEXT AFORO
        afo = new JTextField();
        afo.setBackground(new Color(16, 254, 242));
        afo.setFont(new Font("Bookman Old Style", 1, 15));
        afo.setForeground(Color.DARK_GRAY);
        add(afo);
        afo.setBounds(60, 315, 90, 25);

        //  PERCIO
        JLabel Pr = new JLabel("Precio");
        Pr.setForeground(Color.BLACK);
        Pr.setFont(new Font("Bookman Old Style", 1, 18));
        add(Pr);
        Pr.setBounds(10, 160, 100, 20);

        A = new JLabel("$60");
        A.setForeground(Color.BLACK);
        A.setFont(new Font("Bookman Old Style", 1, 18));
        add(A);
        A.setBounds(20, 185, 100, 20);

        N = new JLabel("$55");
        N.setForeground(Color.BLACK);
        N.setFont(new Font("Bookman Old Style", 1, 18));
        add(N);
        N.setBounds(20, 215, 100, 20);

        // BOLETO
        boleto1 = new JLabel("Boleto");
        boleto1.setForeground(Color.BLACK);
        boleto1.setFont(new Font("Bookman Old Style", 1, 18));
        add(boleto1);
        boleto1.setBounds(90, 160, 100, 20);

        adulto = new JCheckBox("Adulto");
        adulto.setBackground(new Color(125, 251, 172));
        adulto.setFont(new Font("Arial", 1, 14));
        add(adulto);
        adulto.setBounds(80, 184, 80, 20);
        adulto.addItemListener(this);

        niño = new JCheckBox("Niño");
        niño.setBackground(new Color(125, 251, 172));
        niño.setFont(new Font("Arial", 1, 14));
        add(niño);
        niño.setBounds(80, 214, 60, 20);
        niño.addItemListener(this);

        A2x1 = new JCheckBox("2x1");
        A2x1.setBackground(new Color(125, 251, 172));
        A2x1.setFont(new Font("Arial", 1, 14));
        add(A2x1);
        A2x1.setBounds(250, 200, 60, 20);
        A2x1.addItemListener(this);

        JLabel Cantidad = new JLabel("Cantidad");
        Cantidad.setForeground(Color.BLACK);
        Cantidad.setFont(new Font("Bookman Old Style", 1, 18));
        add(Cantidad);
        Cantidad.setBounds(175, 160, 100, 20);

        numA = new JTextField();
        numA.setBackground(new Color(16, 254, 242));
        numA.setFont(new Font("Bookman Old Style", 1, 15));
        add(numA);
        numA.setText("0");
        numA.setBounds(175, 185, 50, 20);

        numN = new JTextField();
        numN.setBackground(new Color(16, 254, 242));
        numN.setFont(new Font("Bookman Old Style", 1, 15));
        add(numN);
        numN.setText("0");
        numN.setBounds(175, 215, 50, 20);

        //----------------- TOTAL A PAGAR -------------------
        previo = new JLabel("TOTAL");
        previo.setForeground(Color.BLACK);
        previo.setFont(new Font("Impact", 1, 22));
        add(previo);
        previo.setBounds(150, 350, 100, 20);

        BOL = new JLabel("Boletos:");
        BOL.setForeground(Color.BLACK);
        BOL.setFont(new Font("Bookman Old Style", 1, 18));
        add(BOL);
        BOL.setBounds(10, 390, 100, 20);

        JLabel ad = new JLabel("Adulto");
        ad.setForeground(Color.BLACK);
        ad.setFont(new Font("Bookman Old Style", 1, 18));
        add(ad);
        ad.setBounds(95, 390, 100, 20);

        JLabel cosA = new JLabel("Monto $");
        cosA.setForeground(Color.BLACK);
        cosA.setFont(new Font("Bookman Old Style", 1, 18));
        add(cosA);
        cosA.setBounds(210, 390, 100, 20);

        montoA = new JTextField();
        montoA.setBackground(new Color(16, 254, 242));
        montoA.setFont(new Font("Bookman Old Style", 1, 15));
        add(montoA);
        montoA.setBounds(165, 390, 30, 20);

        precioA = new JTextField();
        precioA.setBackground(new Color(16, 254, 242));
        precioA.setFont(new Font("Bookman Old Style", 1, 15));
        precioA.setForeground(Color.MAGENTA);
        add(precioA);
        precioA.setBounds(290, 390, 60, 20);

        JLabel an = new JLabel("Niño");
        an.setForeground(Color.BLACK);
        an.setFont(new Font("Bookman Old Style", 1, 18));
        add(an);
        an.setBounds(95, 430, 100, 20);

        montoN = new JTextField(12);
        montoN.setBackground(new Color(16, 254, 242));
        montoN.setFont(new Font("Bookman Old Style", 1, 15));
        add(montoN);
        montoN.setBounds(165, 430, 30, 20);

        JLabel cosN = new JLabel("Monto $");
        cosN.setForeground(Color.BLACK);
        cosN.setFont(new Font("Bookman Old Style", 1, 18));
        add(cosN);
        cosN.setBounds(210, 430, 100, 20);

        precioN = new JTextField();
        precioN.setBackground(new Color(16, 254, 242));
        precioN.setFont(new Font("Bookman Old Style", 1, 15));
        precioN.setForeground(Color.MAGENTA);
        add(precioN);
        precioN.setBounds(290, 430, 60, 20);

        JLabel total2 = new JLabel("Total");
        total2.setForeground(Color.BLACK);
        total2.setFont(new Font("Bookman Old Style", 1, 18));
        add(total2);
        total2.setBounds(200, 480, 50, 20);

        total = new JTextField();
        total.setBackground(new Color(16, 254, 242));
        total.setFont(new Font("Bookman Old Style", 1, 15));
        add(total);
        total.setBounds(255, 480, 90, 20);

        costear = new JButton("COSTEAR");
        costear.setForeground(Color.PINK);
        costear.setFont(new Font("Algerian", 1, 20));
        add(costear);
        costear.setBounds(205, 275, 130, 30);
        costear.addActionListener(this);

        JLabel sub = new JLabel("Subtotal");
        sub.setForeground(Color.BLACK);
        sub.setFont(new Font("Bookman Old Style", 1, 18));
        add(sub);
        sub.setBounds(10, 480, 120, 20);

        Tsin = new JTextField();
        Tsin.setBackground(new Color(16, 254, 242));
        Tsin.setFont(new Font("Bookman Old Style", 1, 15));
        add(Tsin);
        Tsin.setBounds(95, 480, 90, 20);

        JLabel IVA = new JLabel("IVA");
        IVA.setForeground(Color.BLACK);
        IVA.setFont(new Font("Bookman Old Style", 1, 18));
        add(IVA);
        IVA.setBounds(50, 510, 50, 20);

        iva = new JTextField();
        iva.setBackground(new Color(16, 254, 242));
        iva.setFont(new Font("Bookman Old Style", 1, 15));
        add(iva);
        iva.setBounds(95, 510, 90, 20);

        aceptar = new JButton("ACEPTAR");
        aceptar.setForeground(Color.PINK);
        aceptar.setFont(new Font("Algerian", 1, 20));
        add(aceptar);
        aceptar.setBounds(40, 550, 150, 40);
        aceptar.addActionListener(this);

        // BOTON DE TICKET
        imprimir = new JButton("Imprimir Ticket");
        imprimir.setForeground(Color.PINK);
        imprimir.setFont(new Font("Algerian", 1, 20));
        add(imprimir);
        imprimir.setBounds(210, 550, 210, 40);
        imprimir.addActionListener(this);

        // LABEL NOMBRE
        JLabel nombre = new JLabel("Nombre");
        nombre.setForeground(Color.BLACK);
        nombre.setFont(new Font("Bookman Old Style", 1, 18));
        add(nombre);
        nombre.setBounds(200, 510, 100, 20);

        nom = new JTextField();
        nom.setBackground(new Color(16, 254, 242));
        nom.setFont(new Font("Bookman Old Style", 1, 15));
        add(nom);
        nom.setBounds(275, 510, 190, 20);
        
        // BOTON DE LIMPIAR
        limpiar = new JButton("Limpiar");
        limpiar.setForeground(Color.PINK);
        limpiar.setFont(new Font("Algerian", 1, 20));
        add(limpiar);
        limpiar.setBounds(420, 550, 150, 40);
        limpiar.addActionListener(this);
        
        add(background);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == pelicula) {
            pel.setText((String) pelicula.getSelectedItem());
            String salas;
            salas = pel.getText();

            if (salas.equals(" ")) {
                cartel.repaint();
            }
            if (salas.equals("Flash")) {
                Graphics papel = cartel.getGraphics();
                Object origen = e.getSource();
                flash.paintIcon(this, papel, 0, 0);
            }
            if (salas.equals("Shrek")) {
                Graphics papel = cartel.getGraphics();
                Object origen = e.getSource();
                shrek.paintIcon(this, papel, 0, 0);
            }
            if (salas.equals("Spiderman")) {
                Graphics papel = cartel.getGraphics();
                Object origen = e.getSource();
                spiderman.paintIcon(this, papel, 0, 0);
            }
            if (salas.equals("Transformers")) {
                Graphics papel = cartel.getGraphics();
                Object origen = e.getSource();
                transformers.paintIcon(this, papel, 0, 0);
            }

        }

        // RESPUESTA DE ACUERDO A LA OPCION DEL JCOMBOBOX
        String respuesta = (String) lista.getSelectedItem();
        if (respuesta.equals("Normal")) {
            afo.setText("70");
        } else if (respuesta.equals("VIP")) {
            afo.setText("50");
        } else if (respuesta.equals("Cliente Fiel")) {
            afo.setText("35");
        }

        if (e.getSource() == horario) {
            horaprev.setText((String) horario.getSelectedItem());
        }

        if (e.getSource() == lista) {
            afo.setText((String) lista.getSelectedItem());
        }

        if (e.getSource() == costear) {

            double Ad = Double.parseDouble(numA.getText());
            double res = Ad * 60;
            String mon = String.valueOf(res);
            precioA.setText(mon);

            int i = Integer.parseInt(numA.getText());
            String canA = String.valueOf(i);
            montoA.setText(canA);
            int i2 = i % 2;

            double Nd = Double.parseDouble(numN.getText());
            double resN = Nd * 55;
            String monN = String.valueOf(resN);
            precioN.setText(monN);

            int x = Integer.parseInt(numN.getText());
            String canN = String.valueOf(x);
            montoN.setText(canN);
            int x2 = x % 2;

            double pA = 0;
            pA = Double.parseDouble(precioA.getText());
            double pN = 0;
            pN = Double.parseDouble(precioN.getText());

            if (A2x1.isSelected()) {
                if (i > 1) {
                    if (i2 == 1) {
                        pA = ((pA - 60) / 2) + 60;
                    } else {
                        pA = pA / 2;
                    }
                }
                if (x > 1) {
                    if (x2 == 1) {
                        pN = ((pN - 55) / 2) + 55;
                    } else {
                        pN = pN / 2;
                    }
                }
                double p1 = pA;
                String p1A = String.valueOf(p1);
                precioA.setText(p1A);
                precioA.setBackground(new Color(16, 254, 242));

                double p2 = pN;
                String p2N = String.valueOf(p2);
                precioN.setText(p2N);
                precioN.setBackground(new Color(16, 254, 242));

                double sub = pA + pN;
                String subtotal = String.valueOf(sub);
                Tsin.setText(subtotal);
            } else {
                double sub = (pA + pN);
                String subtotal = String.valueOf(sub);
                precioA.setBackground(new Color(16, 254, 242));
                precioN.setBackground(new Color(16, 254, 242));
                Tsin.setText(subtotal);
            }
        }

        if (e.getSource() == imprimir) {
            ticket.setText(" ");
            ticket.setBackground(new Color(111, 242, 181));
            ticket.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 16));
            ticket.setText("\n\n\n");
            ticket.append("                             T-REX Movie Films\n\n");
            ticket.append("                               Galerias Toluca\n                   "
                    + "Toluca de Lerdo C.P. 50070\n\n");
            Calendar fecha = new GregorianCalendar();
            int año = fecha.get(Calendar.YEAR);
            int mes = fecha.get(Calendar.MONTH);
            int dia = fecha.get(Calendar.DAY_OF_MONTH);
            int hora = fecha.get(Calendar.HOUR);
            int minuto = fecha.get(Calendar.MINUTE);
            int segundo = fecha.get(Calendar.SECOND);
            int ampm = fecha.get(Calendar.AM_PM);

            ticket.append("   Fecha: " + dia + "/" + (mes + 1) + "/" + año + "             " + "Hora: " + (hora - 1) + ":" + minuto + ":" + segundo + " " + (ampm == Calendar.AM ? "am" : "pm") + "\n\n\n");

            String salas1;
            salas1 = pel.getText();
            ticket.append("  Pelicula:  " + salas1 + "\n");

            String horaprev2;
            horaprev2 = horaprev.getText();
            ticket.append("  Funcion: " + horaprev2 + "\n");

            String af;
            af = afo.getText();
            ticket.append("  Aforo: " + af + "\n");

            if (A2x1.isSelected()) {
                ticket.append("                                                                                 2x1\n\n");
            } else {
                ticket.append("\n\n");
            }

            if (adulto.isSelected()) {
                int iA = Integer.parseInt(numA.getText());
                String canA2 = String.valueOf(iA);
                double pA = Double.parseDouble(precioA.getText());
                String mon2 = String.valueOf(pA);
                ticket.append(" " + canA2 + "  Boleto Adulto  $" + mon2 + "\n");
            }

            if (niño.isSelected()) {
                int iN = Integer.parseInt(numN.getText());
                String canN2 = String.valueOf(iN);
                double pN = Double.parseDouble(precioN.getText());
                String mon3 = String.valueOf(pN);
                ticket.append(" " + canN2 + "  Boleto Niño  $" + mon3 + "\n");
            }

            double s = Double.parseDouble(Tsin.getText());
            String s2 = String.valueOf(s);
            ticket.append("\n     Subtotal ..................................... $  " + s2 + "\n");

            double iv = Double.parseDouble(iva.getText());
            String iv2 = String.valueOf(iv);
            ticket.append("     IVA ............................................... $  " + iv2 + "\n");

            double t = Double.parseDouble(total.getText());
            String t2 = String.valueOf(t);
            ticket.append("     Total a pagar ............................ $  " + t2 + "\n\n");
            
            String nomprev;
            nomprev = nom.getText();
            ticket.append("                              " + nomprev);

            ticket.append("\n\n\n                ¡Gracias por su eleccion!\n");
            ticket.append("\n\n                  www.trexmovie.com.mx\n\n\n");
        }

        if (e.getSource() == aceptar) {
            double totalsin = 0;
            totalsin = Double.parseDouble(Tsin.getText());
            double iv2 = (totalsin * 0.16);
            String IVA2 = String.valueOf(iv2);
            iva.setText(IVA2);

            double tot2 = (totalsin + iv2);
            String tota2 = String.valueOf(tot2);
            total.setText(tota2);
        }

    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }
}
