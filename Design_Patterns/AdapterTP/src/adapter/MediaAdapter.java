package adapter;

public class MediaAdapter implements MediaPlayer{
	
	AdvancedMediaPlayer advMediaPlayer;
	
	public MediaAdapter(String typeAudio) {
		
		if(typeAudio.equalsIgnoreCase("vlc")) {
			advMediaPlayer = new VlcPlayer();
		} else if (typeAudio.equalsIgnoreCase("mp4")) {
			advMediaPlayer = new Mp4Player();
		}
		
	}
	@Override
	public void play(String typeAudio, String fileName) {
		
		if(typeAudio.equalsIgnoreCase("vlc")) {
			advMediaPlayer.playVlc(fileName);
		} else if (typeAudio.equalsIgnoreCase("mp4")) {
			advMediaPlayer.playMp4(fileName);
		}
		
	}
}
