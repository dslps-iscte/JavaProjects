public class Grafico {
	
	private ColorImage imagem;
	private String tituloGrafico;
	private String eixoX;
	private String eixoY;
	
	public Grafico (ColorImage imagem){
		this.imagem = imagem;
	}
	
	public Grafico(ColorImage imagem, String g, String x, String y){
		this.imagem = imagem;
		this.tituloGrafico = g;
		this.eixoX = x;
		this.eixoY = y;
	}
	
	public void setTituloGrafico (String g){
		this.tituloGrafico = g;
	}
	
	public void setTituloX (String x){
		this.eixoX = x;
	}
	
	public void setTituloY (String y){
		this.eixoY = y;
	}
		
	public void setGraficoTransparente(){
		Color c = new Color(0,0,0);	
		
		for (int i=0; i< imagem.getWidth(); i++){ //linhas
			for (int j=0; j<imagem.getHeight(); j++){ //coluna
				if ((j%2 ==  0 && i%2 !=0) || (j%2 != 0 && i%2==0)) {
					imagem.setColor(i,j,c);
				}
			}
		}
	}
	
	public ColorImage getImage(){
		ColorImage i2 = this.imagem;
		return i2;
	}
	
	public String getTituloGrafico(){
		return this.tituloGrafico;
	}
	
	public String getTituloX(){
		return this.eixoX;
	}
	
	public String getTituloY(){
		return this.eixoY;
	}
	
	public String getTitulos(){
		return "Nome do grafico: " + this.tituloGrafico + " Eixo das Abcissas : " + " " + this.eixoX  + " " + "Eixo das Ordenadas : " + " " + this.eixoY;	
	}

	// funcao aux para parte3
	public String getTitulo(){
		while (this.tituloGrafico!=null){
			return tituloGrafico;
		}
		return "";
	}
	
	
}