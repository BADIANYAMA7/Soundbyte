package za.co.varsitycollege.st10497775.songapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
//ST10497775-BADIANYAMA MUTOMBO BLESS
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //DECLARATIONS
        var SongTitle=findViewById<EditText>(R.id.Title)
        var ArtistName=findViewById<EditText>(R.id.Artist)
        var Ratings=findViewById<EditText>(R.id.Rating)
        var Comments= findViewById<EditText>(R.id.Comments)
        var Addbutton=findViewById<Button>(R.id.Add)
        var ClearButton=findViewById<Button>(R.id.Clear)
        var NextButton=findViewById<Button>(R.id.Next)
        /*THIS IS THE ADD BUTTON WHEN YOU PRESS IT IT'S GOING TO ADD
        YOUR SONG TO A PLAYLIST WHICH YOU CAN SEE ON A OTHER SCREEN*/
        /*AND THE NEXT BUTTON TO THE OTHER SCREEN WILL APPEAR ALLOWING
        TO TRAVEL ONTO THE NEXT SCREEN AND ONCE SONG HAS BEEN ADDED IT
        WILL AUTOMATICALLY CLEAR FOR YOU
         */
        Addbutton.setOnClickListener {
            SONGNAME.listIterator().add(SongTitle.text.toString())
            ARTISTSNAME.listIterator().add(ArtistName.text.toString())
            SONGRATING.listIterator().add(Ratings.text.toString())
            SONGCOMMENTS.listIterator().add(Comments.text.toString())
            SongTitle.text.clear()
            ArtistName.text.clear()
            Ratings.text.clear()
            Comments.text.clear()
            NextButton.visibility=View.VISIBLE
            Toast.makeText(this,"Song Has been added", Toast.LENGTH_LONG).show()

        }
        // CLEAR BUTTON WHEN YOU MADE A MISTAKE SO YOU CAN GO BACK AND CORRECT IT
        ClearButton.setOnClickListener {
            SongTitle.text.clear()
            ArtistName.text.clear()
            Ratings.text.clear()
            Comments.text.clear()
        }
        // BUTTON THAT ALLOWS YOU TO TRAVEL TO THE NEXT SCREEN
        NextButton.setOnClickListener {
            var Intent= Intent(this, Playlists::class.java)
            startActivity(Intent)
        }


    }
}