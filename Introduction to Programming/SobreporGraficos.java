public class SobreporGraficos {
	private Grafico[] grafs;
	private int iAtual = 0;
	public final static int MAX = 10;

	public SobreporGraficos(Grafico g){
		this.grafs = new Grafico[MAX];
		grafs[iAtual]=g;
		iAtual++;
	}

	public SobreporGraficos(ColorImage[] graficos) {  //grafico
		this.grafs = new Grafico[MAX];
		for (int x = 0; x != graficos.length && x != MAX; x++) {
			this.grafs[x] = new Grafico(graficos[x]);
			iAtual++;
		}
	}


	// 1	
	public ColorImage [] pilha(){
		int count = 0;
		for (int x=0; x<grafs.length; x++){
			if (grafs[x] != null){
				count++;
			}
		}

		ColorImage [] c = new ColorImage [count];
		int aux = 0;
		for (int x=0; x<grafs.length; x++){
			if (grafs[x]!=null){
				c[aux] = grafs[x].getImage();
				aux++;
			}
		}
		return c;
	}

	// 2
	public void adicionar(Grafico img) {
		if (iAtual == grafs.length) {
			throw new IllegalArgumentException("Impossivel adicionar");
		}
		grafs[iAtual] = img;
		iAtual++;
	}

	// 3
	public void remover() {
		if (iAtual == 0) {
			throw new IllegalArgumentException("Impossivel remover");
		}
			iAtual--;
			grafs[iAtual]=null;
	}


	// 4
	public ColorImage getGrafico() {
		ColorImage img = grafs[iAtual - 1].getImage(); 
		return img;
	}

	// 5
	public void inserir(Grafico img, int i) {
		if (i >= MAX) {
			throw new IllegalArgumentException("Impossivel inserir");
		}
		for (int x = MAX - 1 ; x > i; x--) {
			grafs[x] = grafs[x - 1];
		}
		grafs[i] = img;
	}

	// 6
	public void trocarGraficos(int x, int y) {
		Grafico aux=null;
		Grafico g1=grafs[x];
		Grafico g2 = grafs[y];
		if (g1!= null && g2!=null){
			aux = g1;
			g1 = g2;
			g2 = aux;
		}
	}

	// 7 

	public  int graficoSemTitulo(Grafico [] img) {
		int count = 0;
		for (int i=0; i!= iAtual; i++){
			if (img[i].getTitulo().equals("")){
				count++;
			}
		}
		return count;
	}


	public Grafico [] obterGraficosSemTitulo(){
		int count=0;
		Grafico [] v = new Grafico [graficoSemTitulo(grafs)];
		for (int i=0; i!=iAtual; i++){
			if (grafs[i].getTitulo().equals("")){
				v[count] = grafs[i];
				count++;
			}
		}
		return v;
	}

	//8

	public Grafico [] ordemAlfabetica (){

		Grafico [] grafsTitulo = new Grafico[MAX];
		Grafico [] grafsSTitulo = new Grafico[MAX];
		String [] str = new String [MAX];
		String temp; //p trocar de posicao
		int aux=0;
		int aux1=0;

		for (int i=0; i<grafs.length; i++){
			if (grafs[i].getTitulo() != null){ // titulos dos graficos q tem titulo
				str[aux] = grafs[i].getTitulo();
				aux++;
			}else{  //graficos sem titulo
				grafsSTitulo[aux1]=grafs[i];
				aux1++;
			}
		}

		for (int i=0; i<MAX; i++){  //ordena os titulos todos
			for (int j= i +1; j<MAX; j++){
				if ( str[i].compareTo(str[j])>0){
					temp = str[i];
					str[i]=str[j];
					str[j]=temp;
				}
			}
		
		//percorrer grafsTitulo e acrescantar stitu
		}
		return grafsTitulo;
		}

	
	

	//9 
	public ColorImage sobrepor(ColorImage a , ColorImage a2){
		int minw = 	Math.min(a.getWidth(),a2.getWidth());
		int minh = 	Math.min(a.getHeight(),a2.getHeight());
		for (int i=0; i< minw; i++){
			for (int j=0; j<minh; j++){
				Color preto = new Color(0,0,0);
				Color aux = a2.getColor(i,j);
				if (aux.getR()!=preto.getR() || aux.getG()!=preto.getG() || aux.getB()!=preto.getB()){ //rgb
					a.setColor(i,j,aux);
				}
			
			
			}
		}
		return a;
	}
			
	//10
	public ColorImage obterSobre90(ColorImage a1, ColorImage b1){
		ColorImage img = ManipulacaoImagens.rotacao90(sobrepor(a1,b1));
		return img;
	}


	static SobreporGraficos Teste() {
		ColorImage[] i = new ColorImage[3];
		int[] v = { 303, 370, 120, 340, 450, 390 };
		int[] v1 = { 20, 70, 120, 170 };
		int a = 20;
		int b = 27;
		Color c = new Color(255, 0, 0);
		Color c1 = new Color(0, 255, 0);
		i[0] = ManipulacaoImagens.grafico2D(v, a, b, c);
		i[1] = ManipulacaoImagens.rotacao90(i[0]);
		i[2] = ManipulacaoImagens.graficoDispersao(v1, a, b, c1);
		SobreporGraficos Teste = new SobreporGraficos(i);
		ColorImage b1 = ManipulacaoImagens.grafico2D(v, a, b, c);
		ColorImage b2 = ManipulacaoImagens.graficoDispersao(v1,a,b,c1);
		Grafico d = new Grafico(b1);
		Teste.adicionar(d);   
		Teste.sobrepor(b1,b2);
		Teste.obterSobre90(b1,b2);
		Grafico[] vec = Teste.obterGraficosSemTitulo();
		return Teste;

	}


}
