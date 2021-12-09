package fr.groupe.event.fragments

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import fr.groupe.event.R

class RegisterEditFragment : Fragment() {
    private lateinit  var auth : FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register_edit, container, false)
        auth = Firebase.auth

        val Username = view.findViewById<EditText>(R.id.edit_text_username)
        val UserEmail = view.findViewById<EditText>(R.id.edit_text_mail)
        val pwd = view.findViewById<EditText>(R.id.edit_text_pwd)
        val Confpwd = view.findViewById<EditText>(R.id.edit_text_conf_pwd)

        val btn = view.findViewById<Button>(R.id.next)
        btn.setOnClickListener{

        if (Username.text.trim().toString().isEmpty()){
            Toast.makeText(requireContext(), " Veuillez remplir le nom d'utilisateur",
                Toast.LENGTH_SHORT).show()
        }else if (!valideEmail(UserEmail)){

        }else if (!(pwd.text.toString().isEmpty()) && !(Confpwd.text.toString().isEmpty())){
            if (pwd.text.toString() == Confpwd.text.toString()){
                auth.createUserWithEmailAndPassword(UserEmail.text.toString(), pwd.text.toString())
                    .addOnCompleteListener(requireActivity()) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(requireContext(), "C'est Firebase",
                                Toast.LENGTH_SHORT).show()
                            val user = auth.currentUser
                                user?.sendEmailVerification()?.addOnCompleteListener { task ->
                                    if (task.isSuccessful) {

                                        Toast.makeText(requireContext(), "Allez Valider votre adresse mail dans votre boite mail",
                                            Toast.LENGTH_SHORT).show()
                                        findNavController().
                                        navigate(R.id.action_viewPagerFragment2_to_loginFragment)
                                    }
                                }

                        } else {
                            // If sign in fails, display a message to the user.

                            Toast.makeText(requireContext(), "Authentication failed.",
                                Toast.LENGTH_SHORT).show()

                        }
                    }
            }else{
                Toast.makeText(requireContext(), " Les mots de passe ne correspond",
                    Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(requireContext(), " Les mots de passe doivent etre remplis",
                Toast.LENGTH_SHORT).show()
        }




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