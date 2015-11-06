package com.example.xo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

public class TwoPlayer extends Activity implements
		android.view.View.OnClickListener {
	// Represents the internal state of the game
	private TicTacToeGame mGame;
	Button mBoardButtons[];
	// Various text displayed
	private TextView mInfoTextView;
	public static String bgColor = "White", linesColor = "Black",
			OColor = "Yellow", XColor = "Red";

	static TableLayout table;
	int xWins, oWins, ties;
	TextView x_Wins, o_Wins, tie;

	boolean xTurn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.board);

		xWins = oWins = ties = 0;
		x_Wins = (TextView) findViewById(R.id.xWins);
		o_Wins = (TextView) findViewById(R.id.oWins);
		tie = (TextView) findViewById(R.id.tie);

		mGame = new TicTacToeGame();
		mBoardButtons = new Button[9];
		mBoardButtons[0] = (Button) findViewById(R.id.one);
		mBoardButtons[1] = (Button) findViewById(R.id.two);
		mBoardButtons[2] = (Button) findViewById(R.id.three);
		mBoardButtons[3] = (Button) findViewById(R.id.four);
		mBoardButtons[4] = (Button) findViewById(R.id.five);
		mBoardButtons[5] = (Button) findViewById(R.id.six);
		mBoardButtons[6] = (Button) findViewById(R.id.seven);
		mBoardButtons[7] = (Button) findViewById(R.id.eight);
		mBoardButtons[8] = (Button) findViewById(R.id.nine);

		mInfoTextView = (TextView) findViewById(R.id.information);
		table = (TableLayout) findViewById(R.id.play_grid);

		SharedPreferences setting = getSharedPreferences("COLORS", 0);
		bgColor = setting.getString("bgColor", "");
		linesColor = setting.getString("lineColor", "");
		OColor = setting.getString("OColor", "");
		XColor = setting.getString("XColor", "");
		colorIt();
		startNewGame();

	}

	@SuppressLint("ResourceAsColor")
	private void colorIt() {

		// buttons color
		if (bgColor.equalsIgnoreCase("White")
				|| (bgColor.equalsIgnoreCase("Default"))) {
			for (int i = 0; i < mBoardButtons.length; i++) {
				mBoardButtons[i].setBackgroundColor(Color.WHITE);
			}
		} else if (bgColor.equalsIgnoreCase("Black")) {
			for (int i = 0; i < mBoardButtons.length; i++) {
				mBoardButtons[i].setBackgroundColor(Color.BLACK);
			}
		} else if (bgColor.equalsIgnoreCase("Blue")) {
			for (int i = 0; i < mBoardButtons.length; i++) {
				mBoardButtons[i].setBackgroundColor(Color.BLUE);
			}
		} else if (bgColor.equalsIgnoreCase("Red")) {
			for (int i = 0; i < mBoardButtons.length; i++) {
				mBoardButtons[i].setBackgroundColor(Color.RED);
			}
		} else if (bgColor.equalsIgnoreCase("Yellow")) {
			for (int i = 0; i < mBoardButtons.length; i++) {
				mBoardButtons[i].setBackgroundColor(Color.YELLOW);
			}
		} else if (bgColor.equalsIgnoreCase("gray")) {
			for (int i = 0; i < mBoardButtons.length; i++) {
				mBoardButtons[i].setBackgroundColor(Color.GRAY);
			}
		} else if (bgColor.equalsIgnoreCase("maroon")) {
			for (int i = 0; i < mBoardButtons.length; i++) {
				mBoardButtons[i].setBackgroundColor(R.color.Maroon);
			}
		} else if (bgColor.equalsIgnoreCase("green")) {
			for (int i = 0; i < mBoardButtons.length; i++) {
				mBoardButtons[i].setBackgroundColor(Color.GREEN);
			}
		} else if (bgColor.equalsIgnoreCase("Ivory")) {
			for (int i = 0; i < mBoardButtons.length; i++) {
				mBoardButtons[i].setBackgroundColor(R.color.Ivory);
			}
		} else if (bgColor.equalsIgnoreCase("FloralWhite")) {
			for (int i = 0; i < mBoardButtons.length; i++) {
				mBoardButtons[i].setBackgroundColor(R.color.FloralWhite);
			}
		} else if (bgColor.equalsIgnoreCase("Orange")) {
			for (int i = 0; i < mBoardButtons.length; i++) {
				mBoardButtons[i].setBackgroundColor(R.color.Orange);
			}
		} else if (bgColor.equalsIgnoreCase("LightSalmon")) {
			for (int i = 0; i < mBoardButtons.length; i++) {
				mBoardButtons[i].setBackgroundColor(R.color.LightSalmon);
			}
		} else if (bgColor.equalsIgnoreCase("DarkOrange")) {
			for (int i = 0; i < mBoardButtons.length; i++) {
				mBoardButtons[i].setBackgroundColor(R.color.DarkOrange);
			}
		} else if (bgColor.equalsIgnoreCase("Tomato")) {
			for (int i = 0; i < mBoardButtons.length; i++) {
				mBoardButtons[i].setBackgroundColor(R.color.Tomato);
			}
		} else if (bgColor.equalsIgnoreCase("DeepPink")) {
			for (int i = 0; i < mBoardButtons.length; i++) {
				mBoardButtons[i].setBackgroundColor(R.color.DeepPink);
			}
		} else if (bgColor.equalsIgnoreCase("Peru")) {
			for (int i = 0; i < mBoardButtons.length; i++) {
				mBoardButtons[i].setBackgroundColor(R.color.Peru);
			}
		}

		// lines color

		if (linesColor.equalsIgnoreCase("White")) {
			table.setBackgroundColor(Color.WHITE);
		} else if (linesColor.equalsIgnoreCase("Black")
				|| linesColor.equalsIgnoreCase("Default")) {
			table.setBackgroundColor(Color.BLACK);
		} else if (linesColor.equalsIgnoreCase("Blue")) {
			table.setBackgroundColor(Color.BLUE);
		} else if (linesColor.equalsIgnoreCase("Red")) {
			table.setBackgroundColor(Color.RED);
		} else if (linesColor.equalsIgnoreCase("Yellow")) {
			table.setBackgroundColor(Color.YELLOW);
		} else if (linesColor.equalsIgnoreCase("gray")) {
			table.setBackgroundColor(Color.GRAY);
		} else if (linesColor.equalsIgnoreCase("maroon")) {
			table.setBackgroundColor(R.color.Maroon);
		} else if (linesColor.equalsIgnoreCase("green")) {
			table.setBackgroundColor(Color.GREEN);
		} else if (linesColor.equalsIgnoreCase("Ivory")) {
			table.setBackgroundColor(R.color.Ivory);
		} else if (linesColor.equalsIgnoreCase("FloralWhite")) {
			table.setBackgroundColor(R.color.FloralWhite);
		} else if (linesColor.equalsIgnoreCase("Orange")) {
			table.setBackgroundColor(R.color.Orange);
		} else if (linesColor.equalsIgnoreCase("LightSalmon")) {
			table.setBackgroundColor(R.color.LightSalmon);
		} else if (linesColor.equalsIgnoreCase("DarkOrange")) {
			table.setBackgroundColor(R.color.DarkOrange);
		} else if (linesColor.equalsIgnoreCase("Tomato")) {
			table.setBackgroundColor(R.color.Tomato);
		} else if (linesColor.equalsIgnoreCase("DeepPink")) {
			table.setBackgroundColor(R.color.DeepPink);
		} else if (linesColor.equalsIgnoreCase("Peru")) {
			table.setBackgroundColor(R.color.Peru);
		}
	}

	// Set up the game board.
	private void startNewGame() {
		mGame.clearBoard();
		for (int i = 0; i < mBoardButtons.length; i++) {
			mBoardButtons[i].setText("");
			mBoardButtons[i].setEnabled(true);
			mBoardButtons[i].setOnClickListener(this);
		}
		mInfoTextView.setText("X turn");
		xTurn = true;
		x_Wins.setText("X Wins : " + xWins);
		o_Wins.setText("O Wins : " + oWins);
		tie.setText("Tie : " + ties);
	}

	@Override
	public void onClick(View v) {
		int whoWin = mGame.checkForWinner();
		if (whoWin == 0) {
			for (int i = 0; i < mBoardButtons.length; i++) {
				if (v.getId() == mBoardButtons[i].getId()) {
					// setMove(TicTacToeGame.HUMAN_PLAYER, i);
					if (mBoardButtons[i].getText().equals("")) {
						if (xTurn) {
							setMove(TicTacToeGame.HUMAN_PLAYER, i);
							xTurn = false;
							mInfoTextView.setText("O turn");
						} else {
							setMove(TicTacToeGame.COMPUTER_PLAYER, i);
							xTurn = true;
							mInfoTextView.setText("X turn");
						}
					}
					break;
				}
			}

		} else if (whoWin == 1) {
			// tie
			tie.setText("Tie : " + (++ties));
			mInfoTextView.setText(R.string.result_tie);
			return;
		} else if (whoWin == 2) {
			x_Wins.setText("X Wins : " + (++xWins));
			mInfoTextView.setText("X Won.");
			disableAll();
			return;
		} else if (whoWin == 3) {
			o_Wins.setText("O Wins : " + (++oWins));
			mInfoTextView.setText("O Won.");
			disableAll();
			return;
		}

		whoWin = mGame.checkForWinner();
		if (whoWin == 0) {
			// int playComputer = mGame.getComputerMove();
			// if (playComputer >= mBoardButtons.length) {
			// mInfoTextView.setText("Errooooor " + playComputer);
			// return;
			// }
			// setMove(TicTacToeGame.COMPUTER_PLAYER, playComputer);
			// mInfoTextView.setText(R.string.turn_human);
		} else if (whoWin == 1) {
			// tie
			tie.setText("Tie : " + (++ties));
			mInfoTextView.setText(R.string.result_tie);
		} else if (whoWin == 2) {
			x_Wins.setText("X Wins : " + (++xWins));
			mInfoTextView.setText("X Won.");
			disableAll();
		} else if (whoWin == 3) {
			o_Wins.setText("O Wins : " + (++oWins));
			mInfoTextView.setText("O Won.");
			disableAll();
		}

		// whoWin = mGame.checkForWinner();
		// if (whoWin == 0) {
		// return;
		// } else if (whoWin == 1) {
		// // tie
		// mInfoTextView.setText(R.string.result_tie);
		// } else if (whoWin == 2) {
		// mInfoTextView.setText(R.string.result_human_wins);
		// disableAll();
		// } else if (whoWin == 3) {
		// mInfoTextView.setText(R.string.result_computer_wins);
		// disableAll();
		// }
	}

	private void disableAll() {
		for (int i = 0; i < mBoardButtons.length; i++) {
			mBoardButtons[i].setEnabled(false);
		}
	}

	@SuppressLint("ResourceAsColor")
	private void setMove(char player, int location) {
		mGame.setMove(player, location);
		mBoardButtons[location].setEnabled(false);
		mBoardButtons[location].setText(String.valueOf(player));

		if (xTurn) {
			if (XColor.equalsIgnoreCase("White")) {
				mBoardButtons[location].setTextColor(Color.WHITE);
			} else if (XColor.equalsIgnoreCase("Black")
					|| XColor.equalsIgnoreCase("Default")) {
				mBoardButtons[location].setTextColor(Color.BLACK);
			} else if (XColor.equalsIgnoreCase("Blue")) {
				mBoardButtons[location].setTextColor(Color.BLUE);
			} else if (XColor.equalsIgnoreCase("Red")) {
				mBoardButtons[location].setTextColor(Color.RED);
			} else if (XColor.equalsIgnoreCase("Yellow")) {
				mBoardButtons[location].setTextColor(Color.YELLOW);
			} else if (XColor.equalsIgnoreCase("gray")) {
				mBoardButtons[location].setBackgroundColor(Color.GRAY);
			} else if (XColor.equalsIgnoreCase("maroon")) {
				mBoardButtons[location].setBackgroundColor(R.color.Maroon);
			} else if (XColor.equalsIgnoreCase("green")) {
				mBoardButtons[location].setBackgroundColor(Color.GREEN);
			} else if (XColor.equalsIgnoreCase("Ivory")) {
				mBoardButtons[location].setBackgroundColor(R.color.Ivory);
			} else if (XColor.equalsIgnoreCase("FloralWhite")) {
				mBoardButtons[location].setBackgroundColor(R.color.FloralWhite);
			} else if (XColor.equalsIgnoreCase("Orange")) {
				mBoardButtons[location].setBackgroundColor(R.color.Orange);
			} else if (XColor.equalsIgnoreCase("LightSalmon")) {
				mBoardButtons[location].setBackgroundColor(R.color.LightSalmon);
			} else if (XColor.equalsIgnoreCase("DarkOrange")) {
				mBoardButtons[location].setBackgroundColor(R.color.DarkOrange);
			} else if (XColor.equalsIgnoreCase("Tomato")) {
				mBoardButtons[location].setBackgroundColor(R.color.Tomato);
			} else if (XColor.equalsIgnoreCase("DeepPink")) {
				mBoardButtons[location].setBackgroundColor(R.color.DeepPink);
			} else if (XColor.equalsIgnoreCase("Peru")) {
				mBoardButtons[location].setBackgroundColor(R.color.Peru);
			}
		} else {
			mBoardButtons[location].setTextColor(Color.rgb(200, 0, 0));
			if (OColor.equalsIgnoreCase("White")) {
				mBoardButtons[location].setTextColor(Color.WHITE);
			} else if (OColor.equalsIgnoreCase("Black")) {
				mBoardButtons[location].setTextColor(Color.BLACK);
			} else if (OColor.equalsIgnoreCase("Blue")) {
				mBoardButtons[location].setTextColor(Color.BLUE);
			} else if (OColor.equalsIgnoreCase("Red")
					|| XColor.equalsIgnoreCase("Default")) {
				mBoardButtons[location].setTextColor(Color.RED);
			} else if (OColor.equalsIgnoreCase("Yellow")) {
				mBoardButtons[location].setTextColor(Color.YELLOW);
			} else if (OColor.equalsIgnoreCase("gray")) {
				mBoardButtons[location].setBackgroundColor(Color.GRAY);
			} else if (OColor.equalsIgnoreCase("maroon")) {
				mBoardButtons[location].setBackgroundColor(R.color.Maroon);
			} else if (OColor.equalsIgnoreCase("green")) {
				mBoardButtons[location].setBackgroundColor(Color.GREEN);
			} else if (OColor.equalsIgnoreCase("Ivory")) {
				mBoardButtons[location].setBackgroundColor(R.color.Ivory);
			} else if (OColor.equalsIgnoreCase("FloralWhite")) {
				mBoardButtons[location].setBackgroundColor(R.color.FloralWhite);
			} else if (OColor.equalsIgnoreCase("Orange")) {
				mBoardButtons[location].setBackgroundColor(R.color.Orange);
			} else if (OColor.equalsIgnoreCase("LightSalmon")) {
				mBoardButtons[location].setBackgroundColor(R.color.LightSalmon);
			} else if (OColor.equalsIgnoreCase("DarkOrange")) {
				mBoardButtons[location].setBackgroundColor(R.color.DarkOrange);
			} else if (OColor.equalsIgnoreCase("Tomato")) {
				mBoardButtons[location].setBackgroundColor(R.color.Tomato);
			} else if (OColor.equalsIgnoreCase("DeepPink")) {
				mBoardButtons[location].setBackgroundColor(R.color.DeepPink);
			} else if (OColor.equalsIgnoreCase("Peru")) {
				mBoardButtons[location].setBackgroundColor(R.color.Peru);
			}
		}
	}

	@Override
	protected void onPause() {
		startNewGame();
		super.onPause();
	}

	@Override
	protected void onRestart() {
		startNewGame();
		super.onRestart();
	}

	@Override
	protected void onResume() {
		startNewGame();
		super.onResume();
	}

	@Override
	protected void onStop() {
		startNewGame();
		super.onStop();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.new_Game) {
			startNewGame();
		} else if (item.getItemId() == R.id.reset) {
			xWins = oWins = ties = 0;
			x_Wins.setText("X Wins : " + xWins);
			o_Wins.setText("O Wins : " + oWins);
			tie.setText("Tie : " + ties);
		}else if (item.getItemId()==R.id.menu) {
			Intent intent = new Intent(getApplicationContext(),com.example.xo.Menu.class);
			startActivity(intent);
//			finish();
		}else if(item.getItemId()==R.id.options){
			Intent intent = new Intent(TwoPlayer.this, Options.class);
			startActivity(intent);
//			finish();
		}
		return true;
	}
}