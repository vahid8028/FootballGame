package football.game;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;


public class FootballGame extends View implements View.OnTouchListener{

    //Display d = ((WindowManager)context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();

    int ballSpeedX = 0;
    int ballSpeedY = 0;

    float startX = 0;
    float startY = 0;
    float endX = 0;
    float endY = 0;

    float previousX = 0;
    float previousY = 0;

    Ball ball;

    public FootballGame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.setOnTouchListener(this);
        Paint paint = new Paint();
        ball = new Ball(context, attributeSet);
    }

    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        Log.d("football", "1");
        //ball.invalidate();
        ball.draw(canvas);

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);

        canvas.drawCircle(620, 620, 21, paint);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        if(ballSpeedX == 0 && ballSpeedY == 0){

            float change = 0;

            switch (event.getAction()){

                case MotionEvent.ACTION_DOWN:
                    startX = event.getX();
                    startY = event.getY();


                case MotionEvent.ACTION_UP:
                    endX = event.getX();
                    endY = event.getY();

            }
            float changeX = endX - startX;
            float changeY = endY - startY;


            if (Math.abs(changeX) < 100 && Math.abs(changeX) >= 50 || Math.abs(changeY) < 100 && Math.abs(changeY) >= 50){
                ballSpeedX = (int)changeX / 10;
                ballSpeedY = (int)changeY / 10;
            }
            else if(Math.abs(changeX) >= 100 && Math.abs(changeX) < 300 || Math.abs(changeY) >= 100 && Math.abs(changeY) < 300 ){
                ballSpeedX = (int)changeX / 20;
                ballSpeedY = (int)changeY / 20;
            }
            else if(Math.abs(changeX) >= 300 && Math.abs(changeX) < 600 || Math.abs(changeY) >= 300 && Math.abs(changeY) < 600 ){
                ballSpeedX = (int)changeX / 45;
                ballSpeedY = (int)changeY / 45;
            }
            else if(Math.abs(changeX) >= 600 && Math.abs(changeX) < 900 || Math.abs(changeY) >= 600 && Math.abs(changeY) < 900 ){
                ballSpeedX = (int)changeX / 75;
                ballSpeedY = (int)changeY / 75;
            }
            else if(Math.abs(changeX) >= 900 || Math.abs(changeY) >= 900 ){
                ballSpeedX = (int)changeX / 100;
                ballSpeedY = (int)changeY / 100;
            }
            else{
                ballSpeedX = (int)changeX / 5;
                ballSpeedY = (int)changeY / 5;
            }

            ball.Update(ballSpeedX, ballSpeedY);

            invalidate();
        }

        return true;
    }
}


/*
class FootballGame implements Runnable {
    long minPrime = 0;
    FootballGame(long minPrime) {
        this.minPrime = minPrime;
    }

    public void run() {
        // compute primes larger than minPrime
        public FootballGame(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.setOnTouchListener(this);
            Paint paint = new Paint();
        }

        protected void onDraw(Canvas canvas){
            super.onDraw(canvas);
            Log.d("football", "1");
            ball.invalidate();

            Paint paint = new Paint();
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.BLUE);

            canvas.drawCircle(620, 620, 21, paint);

        }
    }
}
*/