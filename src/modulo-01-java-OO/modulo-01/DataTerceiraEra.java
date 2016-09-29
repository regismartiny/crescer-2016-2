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
        boolean bissexto = false;;
        // se o ano for maior que 400
        if(ano % 400 == 0){
            bissexto = true;
        // se o ano for menor que 400
        } else if((ano % 4 == 0) && (ano % 100 != 0)){
            bissexto = true;
        } else{
            bissexto = false;
        }
        return bissexto;
    }
}
