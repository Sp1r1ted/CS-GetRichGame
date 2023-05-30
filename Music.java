import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

public class Music extends Actor
{
    private ArrayList<GreenfootSound> musicList;
    private int currentTrackIndex;
    
    public Music()
    {
        musicList = new ArrayList<>();
        currentTrackIndex = 0;
    }
    
    public void addTrack(GreenfootSound track)
    {
        musicList.add(track);
    }
    
    public void play()
    {
        if (musicList.isEmpty()) {
            return;
        }
        
        GreenfootSound currentTrack = musicList.get(currentTrackIndex);
        
        if (!currentTrack.isPlaying()) {
            currentTrack.play();
        }
    }
    
    public void stop()
    {
        for (GreenfootSound track : musicList) {
            track.stop();
        }
    }
    
    public void nextTrack()
    {
        if (musicList.isEmpty()) {
            return;
        }
        
        currentTrackIndex = (currentTrackIndex + 1) % musicList.size();
        
        stop();
        play();
    }
    
    public void previousTrack()
    {
        if (musicList.isEmpty()) {
            return;
        }
        
        currentTrackIndex = (currentTrackIndex - 1 + musicList.size()) % musicList.size();
        
        stop();
        play();
    }
    
    public void setVolume(int volume)
    {
        for (GreenfootSound track : musicList) {
            track.setVolume(volume);
        }
    }
    
    public void fadeOut(int duration)
    {
        int fadeSteps = 20;
        int fadeInterval = duration / fadeSteps;
        int volumeStep = 100 / fadeSteps;
        
        for (int i = 0; i < fadeSteps; i++) {
            int targetVolume = 100 - (i * volumeStep);
            GreenfootSound track = musicList.get(currentTrackIndex);
            track.setVolume(targetVolume);
            
            Greenfoot.delay(fadeInterval);
        }
        
        stop();
    }
}