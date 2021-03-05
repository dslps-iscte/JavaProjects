class TesteParte2 {
	
	static void teste(){
		int[] v = {100,200,300,400};
		int larguraColunas = 20;
		int espacamento = 25;
		Color verm = new Color (255,0,0);
		ColorImage imagemgrafico = ManipulacaoImagens.grafico2D(v,larguraColunas,espacamento,verm);
		String setTituloGrafico = "grafico";
		String setTituloX = "eixo x";
		String setTituloY = "eixo y";
		Grafico gr = new Grafico (imagemgrafico, setTituloGrafico, setTituloX, setTituloY);
		gr.getTitulos();
		gr.setGraficoTransparente();
		gr.getImage();
	}

}