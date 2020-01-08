package adapter;

public class AudioPlayer implements MediaPlayer{

	MediaAdapter mediaAdapter;
	
	@Override
	public void play(String typeAudio, String fileName) {
			
		if(typeAudio.equalsIgnoreCase("mp3")) {
			
			System.out.println("Playing " + typeAudio + " file. Name: " + fileName);
			
		} else if(typeAudio.equalsIgnoreCase("mp4") || typeAudio.equalsIgnoreCase("vlc")){
			
			MediaAdapter mediaAdapter = new MediaAdapter(typeAudio);
			mediaAdapter.play(typeAudio, fileName);
			
			
		} else {
			
			System.out.println("Je ne prend pas ce format");
			
		}
	}	
}
