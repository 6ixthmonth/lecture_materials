package dao;

import java.util.ArrayList;

import vo.Board;

public interface BoardMapper {
	ArrayList<Board> noticeList();
	Board readNotice(int num);
	ArrayList<Board> freeList();
	Board readFree(int num);
}