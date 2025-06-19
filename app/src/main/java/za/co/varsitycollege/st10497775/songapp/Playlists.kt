package za.co.varsitycollege.st10497775.songapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.Display
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
//ST10497775-BADIANYAMA MUTOMBO BLESS
var SONGNAME= arrayListOf<String>("")
var ARTISTSNAME= arrayListOf<String>("")
var SONGRATING=arrayListOf<String>("")
var SONGCOMMENTS=arrayListOf<String>("")
class Playlists : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_playlists)
        //Declaration
        var Index=0
        var Playlist=findViewById<TextView>(R.id.Screen)
        var Backtomenu=findViewById<Button>(R.id.Menu)
        var ShowButton=findViewById<Button>(R.id.Show)
        var Calculate=findViewById<Button>(R.id.AvgRate)
        var AverageText=findViewById<TextView>(R.id.AverageText)
        var ExitButton=findViewById<Button>(R.id.Exit)
        //ALLOWS YOU TO DISPLAY YOUR PLAYLIST
        ShowButton.setOnClickListener {
            Playlist.visibility= View.VISIBLE
            var Display=""
            Display+="SongTitle=${SONGNAME[Index]}\n"
            Display+="Artist Name=${ARTISTSNAME[Index]}\n"
            Display+="Rating=${SONGRATING[Index]}\n"
            Display+="Comments=${SONGCOMMENTS[Index]}\n"
            Playlist.text=Display
            Index++
            if (Index==4){
                ShowButton.visibility= View.GONE
                Calculate.visibility= View.VISIBLE
            }
            // BUTTON TO CALCULATE THE AVERAGE RATINGS FOR ALL THE
            Calculate.setOnClickListener {
                AverageText.visibility= View.VISIBLE
                var Number= SONGRATING.mapNotNull { it.toFloatOrNull() }
                var Sum=Number.average()
                AverageText.text="Average Rating=${Sum}"



            }


        }


        // ALLOWS YOU TO TRAVEL BACK TO THE MAIN SCREEN
        Backtomenu.setOnClickListener {
            var Intent=Intent(this, MainActivity::class.java)
            startActivity(Intent)

        }
        // ALLOWS YOU TO LEAVE THE APPLICATION
        ExitButton.setOnClickListener {
            finishAffinity()


        }


    }
}