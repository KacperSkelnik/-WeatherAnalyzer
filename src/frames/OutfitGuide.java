package frames;

public class OutfitGuide {
	String shoes, hat, clothes, accessories;
	boolean danger = false;
	
	public OutfitGuide() throws Exception {
		WeatherYdnJava date = new WeatherYdnJava();
		
		if(date.status == 5 || date.status == 6 || date.status == 7 || date.status == 8 || date.status == 9 
		|| date.status == 10 || date.status == 11 || date.status == 12 || date.status == 17 || date.status == 18
		|| date.status == 35 || date.status == 40 ) {
			accessories = "parasol";
		}
		else if((date.status == 32 || date.status == 34) && Float.parseFloat(date.WindChill.replace(",",".")) >= 18) {
			accessories = "okulary przeciwsłoneczne";
		}	
		else if(date.status == 0 || date.status == 1 || date.status == 2 || date.status == 3 || date.status == 42 || date.status == 4) {
			shoes = "lepiej";
			hat = "zostań";
			clothes = "w";
			accessories = "domu";
			danger = true;
		}
		else{
			accessories = "dużo uśmiechu :)";
		}
		
		
		
		if(Float.parseFloat(date.WindChill.replace(",", ".")) <= 5 && accessories != "parasol" && danger != true) {
			shoes = "ciepłe buty";
		}
		else if(Float.parseFloat(date.WindChill.replace(",", ".")) > 5 && Float.parseFloat(date.WindChill.replace(",",".")) <= 15 
				&& accessories != "parasol" && danger != true){
			shoes = "półbuty";
		}
		else if(Float.parseFloat(date.WindChill.replace(",", ".")) > 15 && Float.parseFloat(date.WindChill.replace(",",".")) <= 100 
				&& accessories != "parasol" && danger != true){
			shoes = "lekkie buty";
		}
		else if(Float.parseFloat(date.WindChill.replace(",", ".")) >= 7 && Float.parseFloat(date.WindChill.replace(",",".")) <= 100 
				&& accessories == "parasol" && danger != true){
			shoes = "kalosze";
		}
		
		
		
		if(Float.parseFloat(date.WindChill.replace(",", ".")) <= 7 && danger != true) {
			hat = "ciepła czapka";
		}
		else if(Float.parseFloat(date.WindChill.replace(",", ".")) > 7 && Float.parseFloat(date.WindChill.replace(",",".")) <= 20 
				&& danger != true && accessories != "parasol"){
			hat = "czapka z daszkiem";
		}
		else if(Float.parseFloat(date.WindChill.replace(",", ".")) > 20 && Float.parseFloat(date.WindChill.replace(",",".")) <= 100
				&& danger != true){
			hat = "słomkowy kapelusz";
		}
		
		
		
		if(Float.parseFloat(date.WindChill.replace(",", ".")) <= 0 && danger != true) {
			clothes = "gruba kurtka";
		}
		else if(Float.parseFloat(date.WindChill.replace(",", ".")) > 0 && Float.parseFloat(date.WindChill.replace(",",".")) <= 8 
				&& danger != true){
			clothes = "płaszcz";
		}
		else if(Float.parseFloat(date.WindChill.replace(",", ".")) > 8 && Float.parseFloat(date.WindChill.replace(",",".")) <= 16
				&& danger != true && accessories != "parasol"){
			clothes = "lekka kurtka";
		}
		else if(Float.parseFloat(date.WindChill.replace(",", ".")) > 16 && Float.parseFloat(date.WindChill.replace(",",".")) <= 20
				&& danger != true && accessories != "parasol"){
			clothes = "bluza";
		}
		else if(Float.parseFloat(date.WindChill.replace(",", ".")) > 20 && Float.parseFloat(date.WindChill.replace(",",".")) <= 24
				&& danger != true && accessories != "parasol"){
			clothes = "koszula";
		}
		else if(Float.parseFloat(date.WindChill.replace(",", ".")) > 24 && Float.parseFloat(date.WindChill.replace(",",".")) <= 35
				&& danger != true){
			clothes = "t-shirt";
		}
		else if(Float.parseFloat(date.WindChill.replace(",", ".")) > 35 && Float.parseFloat(date.WindChill.replace(",",".")) <= 100
				&& danger != true){
			clothes = "( ͡° ͜ʖ ͡°)";
		}
		else if(Float.parseFloat(date.WindChill.replace(",", ".")) > 8 && Float.parseFloat(date.WindChill.replace(",",".")) <= 24
				&& accessories == "parasol" && danger != true){
			clothes = "kurtka przeciwdeszczowa";
		}
	}
}
