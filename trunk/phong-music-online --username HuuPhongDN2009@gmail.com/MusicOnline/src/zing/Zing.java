package zing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;


public class Zing extends MusicSite{
	private static Map<String, String> songByType = new HashMap<String, String>();
	private static Map<String, String> songByAlbum = new HashMap<String, String>();
	public static String[] titlesSongType;
	public static String[] titlesAlbumType;
	private static Zing zing;
	String htmlSongInfo = "";
	
	private Zing(){
		
	}
	
	public static Zing getInstance(){
		if (zing == null){
			zing = new Zing();
		}
		return zing;
	}

	static {
		String[] songTypes = new String[] {
				"http://mp3.zing.vn/the-loai-bai-hat/Nhac-Viet-Nam/IWZ9Z08I.html",
				"http://mp3.zing.vn/the-loai-bai-hat/Nhac-Tre/IWZ9Z088.html",
				"http://mp3.zing.vn/the-loai-bai-hat/Nhac-Tru-Tinh/IWZ9Z08B.html",
				"http://mp3.zing.vn/the-loai-bai-hat/Rap-Viet/IWZ9Z089.html",
				"http://mp3.zing.vn/the-loai-bai-hat/Rock-Viet/IWZ9Z08A.html",
				"http://mp3.zing.vn/the-loai-bai-hat/Nhac-Cach-Mang/IWZ9Z08C.html",
				"http://mp3.zing.vn/the-loai-bai-hat/Nhac-Que-Huong/IWZ9Z08D.html",
				"http://mp3.zing.vn/the-loai-bai-hat/Nhac-Trinh/IWZ9Z08E.html",
				"http://mp3.zing.vn/the-loai-bai-hat/Nhac-Thieu-Nhi/IWZ9Z08F.html",
				"http://mp3.zing.vn/the-loai-bai-hat/Cai-Luong/IWZ9Z0C6.html",
				"http://mp3.zing.vn/the-loai-bai-hat/Nhac-Phim/IWZ9Z087.html",
				"http://mp3.zing.vn/the-loai-bai-hat/Nhac-Au-My/IWZ9Z08O.html",
				"http://mp3.zing.vn/the-loai-bai-hat/Nhac-Hoa/IWZ9Z08U.html",
				"http://mp3.zing.vn/the-loai-bai-hat/Nhac-Han-Quoc/IWZ9Z08W.html",
				"http://mp3.zing.vn/the-loai-bai-hat/Nhac-Nhat-Ban/IWZ9Z08Z.html",
				"http://mp3.zing.vn/the-loai-bai-hat/Nhac-Hoa-Tau/IWZ9Z086.html",
				"http://mp3.zing.vn/chu-de/nhac-viet-hot/IWZ9Z0C8.html",
				"http://mp3.zing.vn/chu-de/nhac-viet-moi/IWZ9Z0ED.html",
				"http://mp3.zing.vn/chu-de/nhac-xuan/IWZ9Z0DW.html",
				"http://mp3.zing.vn/chu-de/nhac-giang-sinh/IWZ9Z0DO.html",
				"http://mp3.zing.vn/chu-de/hom-nay-nghe-gi/IWZ9Z0FE.html",
				"http://mp3.zing.vn/chu-de/rap-viet-hot/IWZ9Z0CC.html",
				"http://mp3.zing.vn/chu-de/nhac-au-my-hot/IWZ9Z0CB.html",
				"http://mp3.zing.vn/chu-de/nhac-han-hot/IWZ9Z0CA.html",
				"http://mp3.zing.vn/chu-de/nhac-nhat-hot/IWZ9Z0FI.html",
				"http://mp3.zing.vn/chu-de/nhac-san/IWZ9Z0DU.html",
				"http://mp3.zing.vn/chu-de/Love-Songs/IWZ9Z0D9.html",
				"http://mp3.zing.vn/chu-de/the-best-of/IWZ9Z0FU.html",
				"http://mp3.zing.vn/chu-de/zing-collection/IWZ9Z0EB.html" };
		String[] albums = new String[] {
				"http://mp3.zing.vn/the-loai-album/Nhac-Viet-Nam/IWZ9Z08I.html",
				"http://mp3.zing.vn/the-loai-album/Nhac-Tre/IWZ9Z088.html",
				"http://mp3.zing.vn/the-loai-album/Nhac-Tru-Tinh/IWZ9Z08B.html",
				"http://mp3.zing.vn/the-loai-album/Rap-Viet/IWZ9Z089.html",
				"http://mp3.zing.vn/the-loai-album/Rock-Viet/IWZ9Z08A.html",
				"http://mp3.zing.vn/the-loai-album/Nhac-Cach-Mang/IWZ9Z08C.html",
				"http://mp3.zing.vn/the-loai-album/Nhac-Que-Huong/IWZ9Z08D.html",
				"http://mp3.zing.vn/the-loai-album/Nhac-Trinh/IWZ9Z08E.html",
				"http://mp3.zing.vn/the-loai-album/Nhac-Thieu-Nhi/IWZ9Z08F.html",
				"http://mp3.zing.vn/the-loai-album/Cai-Luong/IWZ9Z0C6.html",
				"http://mp3.zing.vn/the-loai-album/Nhac-Phim/IWZ9Z087.html",
				"http://mp3.zing.vn/the-loai-album/Nhac-Au-My/IWZ9Z08O.html",
				"http://mp3.zing.vn/the-loai-album/Nhac-Hoa/IWZ9Z08U.html",
				"http://mp3.zing.vn/the-loai-album/Nhac-Han-Quoc/IWZ9Z08W.html",
				"http://mp3.zing.vn/the-loai-album/Nhac-Nhat-Ban/IWZ9Z08Z.html",
				"http://mp3.zing.vn/the-loai-album/Nhac-Hoa-Tau/IWZ9Z086.html" };

		titlesAlbumType = new String[] { "Nhạc Việt Nam", "Nhạc Trẻ",
				"Nhạc Trữ Tình", "Rap Việt", "Rock Việt", "Nhạc Cách Mạng",
				"Nhạc Quê Hương", "Nhạc Trịnh", "Nhạc Thiếu Nhi", "Cải Lương",
				"Nhạc Phim", "Nhạc Âu Mỹ", "Nhạc Hoa", "Nhạc Hàn Quốc",
				"Nhạc Nhật Bản", "Nhạc Hòa Tấu" };

		titlesSongType = new String[] { "Nhạc Việt Nam", "Nhạc Trẻ",
				"Nhạc Trữ Tình", "Rap Việt", "Rock Việt", "Nhạc Cách Mạng",
				"Nhạc Quê Hương", "Nhạc Trịnh", "Nhạc Thiếu Nhi", "Cải Lương",
				"Nhạc Phim", "Nhạc Âu Mỹ", "Nhạc Hoa", "Nhạc Hàn Quốc",
				"Nhạc Nhật Bản", "Nhạc Hòa Tấu", "Nhạc Hot Việt",
				"Nhạc Việt Mới", "Nhạc Xuân", "Nhạc Giáng Sinh",
				"Hôm Nay Nghe Gì?", "Hot Rap Việt", "Nhạc Hot Âu Mỹ",
				"Nhạc Hot Hàn", "Nhạc Hot Nhật", "Nhạc Sàn", "Love Songs",
				"The Best Of's", "Zing Collection" };

		for (int i = 0; i < albums.length; i++) {
			songByAlbum.put(titlesAlbumType[i], albums[i]);
		}
		for (int i = 0; i < songTypes.length; i++) {
			songByType.put(titlesSongType[i], songTypes[i]);
		}
	};

	public List<Album> getDefaultAlbum() throws IOException {
		return getAlbumBy(titlesAlbumType[0], 1);
	}

	public List<Song> getSongByType(String type, int page) throws IOException {
		return getSongsType(songByType.get(type), page);
	}

	public List<Song> getTopPhong() throws IOException {
		List<Song> songs = new ArrayList<Song>();
		String[] phong = new String[] {
				"http://mp3.zing.vn/xml/playlist/knxGtVGCJagktZFcybmZH",
				"http://mp3.zing.vn/xml/playlist/kGcHydmhuHldtZbJTFGLH",
				"http://mp3.zing.vn/xml/playlist/ZGcGTdHNAJFQTLFJtFnLG" };
		for (int i = 0; i < phong.length; i++) {
			songs.addAll(XMLToSongs(phong[i]));
		}
		return songs;
	}

	public List<Song> getTopKorea() throws UnsupportedEncodingException,
			IOException {
		return getTopSongs("http://mp3.zing.vn/bang-xep-hang/bai-hat/Han-Quoc/IWZ9Z0BO.html");
	}

	public List<Song> getTopVietnamese() throws UnsupportedEncodingException,
			IOException {
		return getTopSongs("http://mp3.zing.vn/bang-xep-hang/bai-hat/Viet-Nam/IWZ9Z08I.html");
	}

	public List<Song> getTopEnglish() throws UnsupportedEncodingException,
			IOException {
		return getTopSongs("http://mp3.zing.vn/bang-xep-hang/bai-hat/Au-My/IWZ9Z0BW.html");
	}

	private List<Song> getTopSongs(String urlTop)
			throws UnsupportedEncodingException, IOException {
		List<Song> lists = new ArrayList<Song>();
		URL url = new URL(urlTop);
		BufferedReader in = new BufferedReader(new InputStreamReader(
				url.openStream(), "UTF-8"));
		String str, title, link;
		while ((str = in.readLine()) != null) {
			if (str.contains("href=\"/bai-hat/") && str.contains("<h3>")) {
				title = getAttribute(str, "title=\"");
				link = "http://mp3.zing.vn" + getAttribute(str, "href=\"");
				lists.add(new Song(title, link));
			}
		}
		in.close();
		return lists;
	}

	// Get link to mp3 of HTML mp3 link
	public String getLink(String mp3URL) throws IOException {
		return XMLToSongs(getXML(mp3URL)).get(0).originLink;
	}

	// Get XML file for song or album
	private String getXML(String link) throws IOException {
		String ret = "";
		URL url = new URL(link);
		BufferedReader in = new BufferedReader(new InputStreamReader(
				url.openStream(), "UTF-8"));
		String str;
		int index = 0;
		while ((str = in.readLine()) != null) {
			if (str.contains("<p class=\"song-info\">")){
				htmlSongInfo = "<html>" + str.trim() + "</html>";
			}
			if (str.contains("<param name=\"flashvars\" value=\"")) {
				index = str.indexOf("http://mp3.zing.vn/xml/");
				ret = str.substring(index);
				ret = new StringTokenizer(ret, "&").nextToken();
				break;
			}
		}
		in.close();
		return ret;
	}

	// Get songs of album
	public List<Song> getAlbum(String html) throws IOException {
		return XMLToSongs(getXML(html));
	}
	
	public List<Song> searchSong(String value, int page, String filter) throws UnsupportedEncodingException, IOException{
		value = URLEncoder.encode(value, "UTF-8");
		List<Song> lists = new ArrayList<Song>();
		URL url = new URL("http://mp3.zing.vn/tim-kiem/bai-hat.html?q=" + value	+ "&p=" + page + filter);
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
		String str, title, link;
		while ((str = in.readLine()) != null) {
			if(str.contains("/bai-hat/")){
				title = getAttribute(str, "title=\"");
				link = "http://mp3.zing.vn" + getAttribute(str, "href=\"");
				Song song = new Song(title, link);
				while ((str = in.readLine()) != null){
					if (str.trim().equalsIgnoreCase("</h3>")) break;
					if (str.contains("title=\"Bài hát chất lượng cao\"")) song.setHighQuality(true);
				}
				in.readLine();
				song.lineTwo = htmlToText(in.readLine()).replace("Đăng bởi:  |", "");
				lists.add(song);
				if (lists.size() >= 20) break;
			}
		}
		in.close();
		return lists;
	}
	
	public String getLinkHighQuality(String linkHTML) throws IOException{
		String ret = "";
	    String data = URLEncoder.encode("zing320kbps", "UTF-8") + "=" + URLEncoder.encode(linkHTML, "UTF-8");
	    URL url = new URL("http://mp3.linhf.com/getlink.php");
	    URLConnection conn = url.openConnection();
	    conn.setDoOutput(true);
	    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
	    wr.write(data);
	    wr.flush();
	    BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
	    String line;
	    while ((line = rd.readLine()) != null) {
	    	if (line.contains("notification fail")){
		    	   return "";
		    }
	    	if (line.contains("<h3><a href")){
	    	   ret = getAttribute(line, "href=\"");
	    	}
	    }
	    wr.close();
	    rd.close();
	    return ret;
	}
	
	public List<Album> searchAlbum(String value, int page, String filter) throws IOException{
		value = URLEncoder.encode(value, "UTF-8");
		List<Album> lists = new ArrayList<Album>();
		URL url = new URL("http://mp3.zing.vn/tim-kiem/playlist.html?q=" + value + "&p=" + page);
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
		String str, title, link, albumArt = "";
		while ((str = in.readLine()) != null) {
			if (str.contains("class=\"album-img\"")){
				albumArt = in.readLine();
				albumArt = albumArt.substring(albumArt.indexOf("src=\"") + 5);
				albumArt = albumArt.substring(0, albumArt.indexOf("\""));
				if (albumArt.equals("http://static.mp3.zing.vn/skins/mp3_v3_16/images/avatar_default_82x82.jpg")) albumArt = "";
			}
			if (str.contains("<a title=\"")) {
				str = str.trim();
				if(str.startsWith("<a title") && str.contains("href")){
					StringTokenizer token = new StringTokenizer(str, "\"");
					token.nextElement();
					title = token.nextToken();
					token.nextElement();
					link = "http://mp3.zing.vn" + token.nextToken();
					Album album = new Album(title, link);
					while ((str = in.readLine()) != null){
						if (str.trim().equalsIgnoreCase("</h3>")) break;
						if (str.contains("title=\"Album chất lượng cao\"")) album.highQuality = true;
					}
					album.info = htmlToText(in.readLine()) + "<br/>" + htmlToText(in.readLine());
					album.albumArt = albumArt;
					lists.add(album);
					if(lists.size() >= 20) break;
				}
			}
		}
		in.close();
		return lists;
	}

	public List<Song> XMLToSongs(String linkXML) throws IOException {
		List<Song> songs = new ArrayList<Song>();
		URL url = new URL(linkXML);
		BufferedReader in = new BufferedReader(new InputStreamReader(
				url.openStream(), "UTF-8"));
		String str;
		String title = "";
		String artist = "";
		String link = "";
		Song song;
		while ((str = in.readLine()) != null) {
			if (str.contains("<item")) {
				title = getContent(in.readLine());
				artist = in.readLine();
				link = in.readLine();
				song = new Song();
				song.setOriginLink(getContent(link));
				song.setTitle(title + " - " + getContent(artist));
				songs.add(song);
			}
		}
		in.close();
		return songs;
	}

	private String getContent(String str) {
		int from = str.lastIndexOf("[");
		int to = str.indexOf("]");
		if (from == -1) {
			from = str.indexOf(">");
			to = str.lastIndexOf("<");
		}
		return str.substring(from + 1, to).trim();
	}

	private List<Song> getSongsType(String linkType, int page) throws UnsupportedEncodingException, IOException {
		List<Song> lists = new ArrayList<Song>();
		URL url = new URL(linkType + "?p=" + page);
		BufferedReader in = new BufferedReader(new InputStreamReader(
				url.openStream(), "UTF-8"));
		String str, title, link;
		while ((str = in.readLine()) != null) {
			if (str.contains("<h2><a title=\"")
					|| str.contains("<h3><a title=\"")) {
				StringTokenizer token = new StringTokenizer(str, "\"");
				token.nextElement();
				title = token.nextToken();
				token.nextElement();
				link = "http://mp3.zing.vn" + token.nextToken();
				Song song = new Song(title, link);
				song.lineOne = htmlToText(in.readLine());
				song.lineTwo = htmlToText(in.readLine());
				lists.add(song);
			}
		}
		in.close();
		return lists;
	}

	public List<Album> getAlbumBy(String type, int page) throws IOException {
		return getPlayListBy(songByAlbum.get(type), page);
	}

	private List<Album> getPlayListBy(String typePlaylistLink, int page)
			throws IOException {
		List<Album> albums = new ArrayList<Album>();
		URL url = new URL(typePlaylistLink + "?p=" + page);
		BufferedReader in = new BufferedReader(new InputStreamReader(
				url.openStream(), "UTF-8"));
		String str;
		int from = -1;
		int to = -1;
		String title = "";
		String link = "";
		String img = "";
		while ((str = in.readLine()) != null) {
			if (str.contains("<span class=\"album-detail-img\">")){
				img = getAttribute(str, "src=\"");
			}
			if (str.contains("<a class=\"_trackLink\"") && str.trim().startsWith("<a class=\"_trackLink\"")) {
				from = str.indexOf("title=\"");
				to = str.indexOf("\" href=\"");
				title = str.substring(from + 7, to);
				link = "http://mp3.zing.vn"	+ str.substring(to + 8).split("\"")[0];
				in.readLine();
				in.readLine();
				Album album = new Album(title, link);
				album.info = "Năm phát hành : " + htmlToText(in.readLine().trim()) + " | " + "Lượt nghe trong tuần: " + htmlToText(in.readLine().trim());
				album.albumArt = img;
				albums.add(album);
			}
		}
		in.close();
		return albums;
	}
	
	public List<String> getLyric(Song song) throws IOException{
		List<String> lyrics = new ArrayList<String>();
		URL url = new URL(song.getLink());
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
		String str, lyric;
		while ((str = in.readLine()) != null) {
			if (str.contains("<p class=\"_lyricContent")) {
				while ((str = in.readLine()) != null){
					lyric = htmlToText(str);
					if (!lyric.trim().equals("")) lyrics.add(lyric);
					if (str.contains("</p>")){
						in.close();
						return lyrics;
					}
				}
			}
		}
		in.close();
		return lyrics;
	}
}