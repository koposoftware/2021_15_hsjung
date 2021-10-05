<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>D.Live - Channel List </title>
    <base href="/">
    <style>
    	.channel-list{ 
		    border: 1px solid #ccc; 
		    height: 700px; 
		}
		.channel-box{
		    width: 230px; height: 220px; 
		    border: 1px dotted #aaa;
		    text-align: left;
		    display: inline-block;
		    margin: 15px;
		}
		.channelBox h3 a{ color: #000; text-decoration: none; cursor: pointer;}
		.channelBox h3 a:hover{text-decoration: underline;}
		.channelBox h5 { color: #aaa; text-decoration: underline;}
		.channel-info{
		    white-space: nowrap;
		    padding: 0 0 0 2px;
		    font-size: 12px;
		    color: #999;
		    line-height: 20px;
		}
		.channel-box p a {
		    padding: 4px 0 0 2px;
		    font-size: 14px;
		    line-height: 15px;
		    color: #000;
		    word-break: break-all;
		    overflow: hidden;
		    text-overflow: ellipsis;
		    text-decoration: none;
		 }
		 li.channel-box p {
		    margin-block-start: 0px;
		    margin-block-end: 5px;
		    margin-inline-start: 0px;
		    margin-inline-end: 0px;
		 }
		 .channel-box p a:hover{ color: #7C5CB2; text-decoration: underline;}
    </style>
</head>
<body>
    <label>Name :</label><input type="text" name="userName" id="userName">
    <button type="button" id="startLiveBtn">방송시작</button>
    <button type="button" id="channel-reload">새로고침</button>
    <div class="list"></div>
    <div id="channel-list">
       <ul></ul>
    </div>

    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/socket.io/2.3.0/socket.io.dev.js"></script>
    <script>
    var socket = io.connect('${socketPort}');

    var startLiveBtn = document.getElementById('startLiveBtn')
    var reloadBtn = document.getElementById('channel-reload')
    var channelList = document.getElementById('channel-list')

    var random 
    var roomArr = []

    $(function(){

        socket.emit('requestRoomlist')
        
        socket.on('roomlist', (rooms) => {
            console.log(rooms)
            if(rooms.length == 0){
                $('ul').append(`<li>개설된 방이 없습니다!</li>`)
            }else{
                addRoomList(rooms)
            }
        })

    })

    function addRoomList(list){
        $('ul').html('')
        list.forEach( item => {
            console.log(item);
            appendRoom(item)
        });
    }

    function appendRoom(item){
    	
    	
        var roomUnit = `<li class="channel-box">
                        <a href="${pageContext.request.contextPath}/socket/guest/${item.room}">
                            <img src="${item.thumb}" width="228" height="128">
                        </a>
                        <p><a href="${pageContext.request.contextPath}/socket/guest/${item.room}"</a></p>
                        <div class="channel-info">
                            <div>
                                <p>${item.date}</p>
                                <p>&nbsp;|&nbsp;</p>
                                <p>${item.caster}</p>
                            </div>
                            <div>
                                <!-- 접속자수 -->
                                <span>
                                    <span>＠</span>
                                    <span>Test</span>
                                </span>
                                <!-- 좋아요 수 -->
                                <span>
                                    <span>♥</span>
                                    <span>Test</span>
                                </span>
                            </div>
                        </div>
                        </li>`
        $('ul').append(roomUnit)
    }

    startLiveBtn.addEventListener('click', ()=>{ 
        //random = parseInt(Math.random()*999999999999)
        //location.href = `/caster/${random}`
        location.href = "${pageContext.request.contextPath}/caster/183321261726"
    })
    reloadBtn.addEventListener('click', ()=>{
        socket.emit('requestRoomlist')
    })
    </script>
    
   
</body>
</html>