# Controllify v0.1
Benjamin Shanahan, 6 January 2017.

Run Controllify.bat and TX Emulator. COM 4 and COM 5 should be linked via COM port emulator utility.

Inside of the emulator, try the following commands:

* >>>play
    * >>> next
    * >>> prev
    * >>> volup
    * >>> voldown
    * >>> visible
    * >>> mute

Additionally, you can input a Spotify URI (right click a song, playlist, album, etc. within
Spotify Desktop and click Copy Spotify URI). Doing so will play the given track in Spotify 
Desktop.

Please note that for most of the functionality of this application, the keyboard shortcuts
called by Controllify must correspond to those defined in Toastify. The Toastify hotkeys are
defined below (or they can be changed in keyboard.py):

* Play / Pause     =     Ctrl-Alt-Up
    Next Track       =     Ctrl-Alt-Right
    Previous Track   =     Ctrl-Alt-Left
    Show / Hide      =     Ctrl-Alt-Down
    Mute             =     Ctrl-Alt-F10
    Volume Down      =     Ctrl-Alt-F11
    Volume Up        =     Ctrl-Alt-F12
