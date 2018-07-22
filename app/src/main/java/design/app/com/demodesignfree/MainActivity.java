package design.app.com.demodesignfree;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import design.app.com.demodesignfree.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;
    private Animation slideInRightAnimation;
    private Animation slideOutRightAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.tvLogin.setOnClickListener(this);
        binding.tvSignUp.setOnClickListener(this);

        slideInRightAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_in_right);
        slideOutRightAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_out_right);

    }

    @Override
    public void onClick(View view) {
        if (view == binding.tvLogin) {
            doAnimationView(view);
        }
        if (view == binding.tvSignUp) {
            doAnimationView(view);
        }

    }

    private void doAnimationView(View view) {
        if (view == binding.tvLogin) {
            if (binding.groupViewLogin.getVisibility() == View.GONE) {

                binding.groupViewSignup.setVisibility(View.GONE);
                binding.tvSignUp.setBackgroundColor(Color.TRANSPARENT);

                binding.tvLogin.setBackgroundResource(R.drawable.draw_selected_button);
                binding.ivArrowLogin.startAnimation(slideInRightAnimation);
                binding.constraintLogin.startAnimation(slideInRightAnimation);
                binding.btnLogin.startAnimation(slideInRightAnimation);
                binding.groupViewLogin.setVisibility(View.VISIBLE);

            } else {

                binding.tvLogin.setBackgroundColor(Color.TRANSPARENT);
                binding.ivArrowLogin.startAnimation(slideOutRightAnimation);
                binding.constraintLogin.startAnimation(slideOutRightAnimation);
                binding.btnLogin.startAnimation(slideOutRightAnimation);
                binding.groupViewLogin.setVisibility(View.GONE);
            }
        }

        if (view == binding.tvSignUp) {
            if (binding.groupViewSignup.getVisibility() == View.GONE) {

                binding.groupViewLogin.setVisibility(View.GONE);
                binding.tvLogin.setBackgroundColor(Color.TRANSPARENT);

                binding.tvSignUp.setBackgroundResource(R.drawable.draw_selected_button);
                binding.ivArrowSignup.startAnimation(slideInRightAnimation);
                binding.scrollviewSignup.startAnimation(slideInRightAnimation);
                binding.btnSignUp.startAnimation(slideInRightAnimation);
                binding.groupViewSignup.setVisibility(View.VISIBLE);

            } else {

                binding.tvSignUp.setBackgroundColor(Color.TRANSPARENT);
                binding.ivArrowSignup.startAnimation(slideOutRightAnimation);
                binding.scrollviewSignup.startAnimation(slideOutRightAnimation);
                binding.btnSignUp.startAnimation(slideOutRightAnimation);
                binding.groupViewSignup.setVisibility(View.GONE);
            }
        }
    }
}
