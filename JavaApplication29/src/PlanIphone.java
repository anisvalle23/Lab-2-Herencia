
public class PlanIphone extends Plan{
   
    private String email;
    
   public PlanIphone(int numeroTelefono, String nombreCliente){
        super (numeroTelefono, nombreCliente);
        this.email = email;
        
    } 
    
   double pagoMensual(int mins, int msgs){
      if (mins>0){
         mins = (int) (mins*0.4);
      }
      if (msgs>0){
          msgs = (int) (msgs*0.1);
      }
      return 22 + mins + msgs; 
   }
   
    public String imprimir() {
        return super.imprimir() + "\nEmail:" + email;
    }
    
     public String getEmail(){
        return email;
    }

    void setEmail(String extra) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
