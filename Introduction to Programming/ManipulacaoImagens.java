class ManipulacaoImagens {

	//1

	static ColorImage grafico2D (int [] v , int widthC, int x, Color c){
		int ValorMax =	valorMaximo(v);
		int largura = v.length*widthC + (v.length + 1)*x; 
		int count =0;

		ColorImage img = new ColorImage (largura, ValorMax);

		for (int j=x; j<=img.getWidth() - widthC - x;j+= x + widthC){ 

			img = criarColuna(img,j, j + widthC, img.getHeight(), img.getHeight() + v[count], c);
			count ++;

		}
		return img;
	}

	static ColorImage testgrafico2D(){
		int [] v =  {303,370,120,340,450,390};
		int a = 20;
		int b= 27;
		Color c = new Color (255,0,0);
		ColorImage img = grafico2D (v,a,b,c);
		return img;
	}

	static int valorMaximo (int [] v){
		int max= 0;
		for (int i=0; i!=v.length; i++){
			if (v[i]>max){
				max=v[i];
			}
		}
		return max;
	}


	static ColorImage criarColuna (ColorImage img,int x0, int x1, int y0, int y1, Color c){	
		for (int x=x0; x!= x1; x++){
			for (int y=img.getHeight() - 1; y!= img.getHeight() - ( y1 - y0); y--){
				img.setColor(x,y,c);
			}
		}
		return img;
	}

	static ColorImage testcriarColuna(){
		ColorImage i = new ColorImage (100,200);
		int x0=0; 
		int x1= 40;
		int y0=0;
		int y1=100;
		Color c = new Color (255,0,0);
		ColorImage img2 = criarColuna(i,x0,x1,y0,y1,c);
		return img2;
	}

	//2


	//3
	static ColorImage graficoDispersao (int [] v, int raio, int esp, Color c){
		int altura= valorMaximo(v);
		int largura =  v.length*raio*2 + (v.length + 1)*esp;
		int count =  0;

		ColorImage img = new ColorImage (largura, altura);
		for (int i=esp; i<= img.getWidth() - esp - raio*2; i+=esp + raio*2){

			img = circulo(img,i + raio,img.getHeight() - 1 - v[count], raio, c); 
			count++;
		}

		return img;
	}

	static ColorImage testgraficoDispersao(){
		int [] v =  {20,70,120,170};
		int a = 10;
		int b= 7;
		Color c = new Color (0,255,0);
		ColorImage img = graficoDispersao (v,a,b,c);
		return img;
	}				


	static ColorImage circulo (ColorImage img, int x, int y, int raio, Color c){
		for (int a= x - raio; a!=x + raio ; a++){
			if (a>=0 && a<img.getWidth()){
				for (int b=y - raio; b!=y+raio; b++){
					if(b>=0 && b<img.getHeight()){
						if (Math.sqrt((a-x)*(a-x) + (b-y)*(b-y))<=raio){
							img.setColor(a,b,c);
						}
					}
				}
			}
		}
		return img;
	}

	static ColorImage testcirculo(){
		ColorImage img = new ColorImage (100,100);
		Color c = new Color (0,255,0);
		ColorImage img2 = circulo (img, 50,50,40,c);
		return img2;
	}

	//4
	static ColorImage rotacao90 (ColorImage img){
		ColorImage nova = new ColorImage (img.getHeight(), img.getWidth());
		for (int x = 0; x!= img.getWidth(); x++){
			for (int y=0; y!=img.getHeight(); y++){
				Color a = img.getColor(x,y);
				nova.setColor(img.getHeight() - 1 - y, x , a);
			}
		}
		return nova;
	}

	static ColorImage testrotacao90(){
		int [] v =  {303,370,120,340,450,390};
		int a = 20;
		int b= 27;
		Color c = new Color (255,0,0);
		ColorImage img = grafico2D (v,a,b,c);
		ColorImage img2 = rotacao90(img);
		return img2;
	}

}	