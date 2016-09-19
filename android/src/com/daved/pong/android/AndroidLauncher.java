package com.daved.pong.android;

import org.mini2Dx.android.AndroidMini2DxConfig;

import com.badlogic.gdx.backends.android.AndroidMini2DxGame;

import android.os.Bundle;

import com.daved.pong.MyMini2DxGame;

public class AndroidLauncher extends AndroidMini2DxGame {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidMini2DxConfig config = new AndroidMini2DxConfig(MyMini2DxGame.GAME_IDENTIFIER);
        initialize(new MyMini2DxGame(), config);
    }
}
