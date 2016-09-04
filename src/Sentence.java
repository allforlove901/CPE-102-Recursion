
public class Sentence {

	private String sentence;
	private int index = 0;
	
	public Sentence(String aSentence){
		sentence = aSentence;
	}
	
	public int find(String t){		
		if(sentence.length()<t.length()){
			return -1;
		}
		else if(t.equals(sentence.substring(0, t.length()))){
			return index;
		}
		else{
			Sentence smaller = new Sentence(sentence.substring(1));
			smaller.index = smaller.getIndex(index);
			return smaller.find(t);
		}
	}
	
	public int getIndex(int anIndex){
		return anIndex + 1;
	}
	
	
}
