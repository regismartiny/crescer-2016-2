public class DataTerceiraEra
{
    private int dia, mes, ano;
    
    public DataTerceiraEra(int dia, int mes, int ano)
    {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
    
    public int getDia() {
        return dia;
    }
    
    public int getMes() {
        return mes;
    }
    
    public int getAno() {
        return ano;
    }    
    
    public boolean ehBissexto() {
        boolean bissexto = false;
        if(ano%4==0){
            if (ano%100!=0){
                bissexto = true;
            }
        }else if(ano%400==0){
            bissexto = true;
        }
        return bissexto;
    }
}
