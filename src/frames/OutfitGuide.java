package frames;

public class OutfitGuide {
	String shoes, hat, clothes, accessories;
	
	public OutfitGuide() throws Exception {
		WeatherYdnJava date = new WeatherYdnJava();
		
		if(date.status == 5 || date.status == 6 || date.status == 7 || date.status == 8 || date.status == 9 
		|| date.status == 10 || date.status == 11 || date.status == 12 || date.status == 17 || date.status == 18
		|| date.status == 35 || date.status == 40 ) {
			accessories = "parasol";
		}
		if((date.status == 32 || date.status == 34) && Float.valueOf(date.Temp) >= 18) {
			accessories = "okulary przeciws³oneczne";
		}
		
		if(date.status == 0 || date.status == 1 || date.status == 2 || date.status == 3 || date.status == 42) {
			shoes = "lepiej";
			hat = "zostañ";
			clothes = "w";
			accessories = "domu";
		}
		else{
			accessories = "du¿o uœmiechu :)";
		}
		
		
		
	}
}
