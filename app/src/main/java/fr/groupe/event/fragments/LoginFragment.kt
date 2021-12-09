package fr.groupe.event.fragments

import android.os.Bundle
import android.util.Log
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import fr.groupe.event.MainActivity
import fr.groupe.event.R
import org.w3c.dom.Text
import java.util.regex.Pattern


class LoginFragment : Fragment() {

    private lateinit  var auth : FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        auth = Firebase.auth
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_login, container, false)
           val email  = view.findViewById<EditText>(R.id.edit_text_mail)
        val pwd = view.findViewById<EditText>(R.id.edit_text_pwd)
        val btnLogin = view.findViewById<Button>(R.id.btn_login)

            val emaiText = email.text.toString()

        btnLogin.setOnClickListener {
            if (valideEmail(email) && !(pwd.text.toString().isEmpty())){
                auth.signInWithEmailAndPassword(email.text.toString(), pwd.text.toString())
                    .addOnCompleteListener(requireActivity()) { task ->
                        if (task.isSuccessful) {

                            // Sign in success, update UI with the signed-in user's information
                            val user = auth.currentUser
                            if (user?.isEmailVerified()== true){
                                Toast.makeText(requireContext(), "Authentication Successfully.",
                                    Toast.LENGTH_SHORT).show()
                                findNavController().navigate(R.id.action_loginFragment_to_mainActivity)

                            }else{
                                Toast.makeText(requireContext(), "Allez Valider votre adresse mail dans votre boite mail",
                                    Toast.LENGTH_SHORT).show()
                            }

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(requireContext(), "Authentication failed.",
                                Toast.LENGTH_SHORT).show()

                        }
                    }
            }else{
                Toast.makeText(requireContext(), " Mot de passe invalide",
                    Toast.LENGTH_SHORT).show()
            }
        }

         val linkToRegister = view.findViewById<TextView>(R.id.link)
        linkToRegister.setOnClickListener{
            findNavController().navigate(R.id.action_loginFragment_to_viewPagerFragment2)
        }


        return view
    }

    fun valideEmail(edText : EditText) : Boolean{
        val email = edText.text.toString()
        if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            return  true
        }else{
           Toast.makeText(requireContext(),"Adresse mail invalide", Toast.LENGTH_SHORT).show()
            return false
        }
    }

}