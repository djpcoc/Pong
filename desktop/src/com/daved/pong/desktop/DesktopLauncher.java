package com.daved.pong.desktop;

import org.mini2Dx.desktop.DesktopMini2DxConfig;

import com.badlogic.gdx.backends.lwjgl.DesktopMini2DxGame;

import com.daved.pong.MyMini2DxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		DesktopMini2DxConfig config = new DesktopMini2DxConfig(MyMini2DxGame.GAME_IDENTIFIER);
		config.vSyncEnabled = true;
		new DesktopMini2DxGame(new MyMini2DxGame(), config);
	}
}
