package vista;
import java.awt.BorderLayout;

import javax.swing.*;

import procesamiento.Aplicacion;
import procesamiento.LoaderProyectos;

@SuppressWarnings("serial")
public class FPrincipal extends JFrame {
	public Aplicacion aplicacion;
	private LoaderProyectos load;
	private FPrincipal principal;
	private PPrincipal pPrincipal;
	
	@SuppressWarnings("deprecation")
	public FPrincipal()
    {	
		
		// Library for good look
		this.principal = this;
		// Se crea la conexion con la lógica y se cargan los datos
		this.aplicacion = new Aplicacion();
		this.load = new LoaderProyectos();
		this.load.cargarAplicacion(this.aplicacion);
			
        // Modern Layout FlatLightLaf
        this.setTitle("Project Manager");
        this.setSize(1020,720);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
		setLocationRelativeTo(null);
        
        // Create the Menu
        PMenu menu = new PMenu(this.principal);
        this.setJMenuBar(menu);
        
        //Create status bar
        PStatus statusbar = new PStatus();
		aplicacion.addObserver(statusbar);
        this.add(statusbar, BorderLayout.SOUTH);
        
        // Create the Principal Buttons
        pPrincipal = new PPrincipal(this);
        this.add(pPrincipal, BorderLayout.CENTER);   
        
        PStart start = new PStart(pPrincipal, this);
        this.add(start, BorderLayout.WEST);
        
        
 
        
    }

    public static void main(String[] args) {
        FPrincipal principal = new FPrincipal();
        principal.setVisible(true);
        principal.setResizable(false);
    }
    
    public Aplicacion getAplicacion() {
    	return this.aplicacion;
    }
    
    public LoaderProyectos getLoader(Aplicacion aplicacion) {
    	return this.load;
    }
    
    public PPrincipal getPPrincipal() {
    	return this.pPrincipal;
    }
    

}
