<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
      <style>
	#channel-icon{ 
	    width: 52px; height: 52px;
	    border-radius: 5em;
	    background-image: url('http://www.kyeongin.com/mnt/file/201907/20190716001537091_1.jpg');
	    background-repeat: no-repeat;
	    background-size: cover;
	    display: inline-block;
	}
	#channel-name-area a{ text-decoration: none; }
	#channel-name-area a:hover{ color: #7C5CB2;/*#785FB3;*/ }
	#channel-name{
	    color: #414141;
	    font-size: 19px;
	    overflow: hidden;
	    text-overflow: ellipsis;
	    white-space: nowrap;
	    position: relative;
	    display: inline-block;
	    top: -50%;
	    bottom: 50%;
	    vertical-align: middle;
	}
	#channel-follow{
	    width:80px;
	    height: 35px;
	    line-height: 33px;
	    border: 1px solid #a8a8a8;
	    background: transparent;
	    border-radius: 31px;
	    padding: 0 17px 0 14px;
	    font-size: 14px;
	    color: #414141;
	    cursor: pointer;
	    float: left;
	    position: relative;
	    top: 50%;
	    bottom: 50%;
	}
	
	.live-booth{
	    width: 75%;
	    border: 1px solid #ddd;
	    margin: 0px;
	    border-right: none;
	    float: left;
	}
	.live-booth .video{
	    width: 100%;
	    height: 100%;
	    position: relative;
	    z-index: 99;
	}
	.channel-controlbox{ 
	    width: 100%;
	    float: right;
	    text-align: right;
	}
	.channel-video-area{
	    width:100%;
	    height: 0px;
	    background: #414141;
	    padding: 0;
	}
	.chatbox{ 
	    width: 25%;
	    border: 1px solid #ddd;
	    background-color: #FAFAFA;
	}
	.chatroom, .chatroom-form, .chatroom-top{ 
	    width: 100%;
	    margin: 0px;
	    border-top: 1px solid #ddd;
	}
	.chatroom{
	    height: 520px;
	    overflow-y: scroll;
	    overflow-x: hidden;
	}
	.chatroom-top{ height: 65px; display: block; }
	.chatroom-form { height: 45px;  display: block;}
	
	.chatroom-form form input{
	    border: 0; 
	    padding: 7px; 
	    width: 100%; height:43px;
	    font-size: 13px;
	    margin-right: .5%;
	    display: block;
	}
	.chatroom-form form button{
	    width: 13.5%; 
	    background: rgb(255, 229, 52); 
	    border: none; 
	    border-radius: 0.2em; 
	    padding: 10px; 
	    font-weight: bold;
	    display: block;
	}
	.channel-onair-info{
	    width: 100%; height: 80px;
	    margin: 0;
	    line-height: 1.5em;
	    text-align: left;
	}
	#messages {
	    list-style-type: none;
	    padding: 0;
	}
	#messages li {
	    padding: 5px 10px;
	    font-size: 13px;
	    display: block;
	    max-width: 100%;
	    margin: 5px;
	    clear: both;
	    word-break: break-all;
	}
	#messages li p{ 
	    display: block; 
	    margin: 0;
	    font-size: 14px;
	}
	#messages p.nameSpace{
	    display: inline-block;
	    color: #7C5CB2;
	    font-size: 12px;
	}
	#messages p.nameSpace:hover{
	    cursor: grab;
	}
	#messages p.nameSpace:active{
	    cursor: grabbing;
	}
	#messages li.other{
	    float: left;
	}
	#messages li.me{
	    background: rgb(255, 229, 52);
	    float: right;
	}
	#messages li.server{
	    text-align: center;
	    background: #7C5CB2;
	    border: 1px solid #7C5CB2;
	}
	#onair-title {
	    overflow: hidden;
	    text-overflow: ellipsis;
	    white-space: nowrap;
	    position: relative;
	    z-index: 1;
	    display: inline-block;
	    *display: inline;
	    *zoom: 1;
	    margin: 13px 0 5px 15px;
	    height: 26px;
	    max-width: 690px;
	    font-size: 20px;
	    line-height: 26px;
	    font-weight: 500;
	    color: #000;
	}
	#info-title, #info-numOf-visitor{ display: inline-block; }
	#info-title{
	    width: 78%;
	}
	#info-numOf-visitor{
	    float:right;
	    width:20%;
	    line-height: 6em;
	    height: 100%;
	}
	#info-numOf-visitor span h4, #info-numOf-visitor span { display: inline;}
	#info-numOf-visitor span{ font-size: 13px; color: #414141; }
    </style>
<div class="removeArea">
	<div class="container-fluid h-100" style="margin-top: 70px; position:fixed; z-index:3; " class="chatArea">
			<div class="row justify-content-center ">
				<div class="col-md-6 col-xl-6 chat" style="display:none" id="videoArea">
					<div class="card mb-sm-3 mb-md-0 contacts_card" style="width: 685px;float:right;" >
							<div class="card-body contacts_body" style="height:450px; background-color:#fff!important; border-radius: 14px">
						   		<div class="channel-video-area">
			                    	<video class="video" id="video" autoplay controls style="width: 650px;height:400px;float:right;margin:15px;"></video>
			                	</div> 
							</div>
					</div>
				</div>
				<div class="col-md-4 col-xl-4 chat" style="margin-right:10%">
					<div class="card" style="background-color:#fff!important;">
						<div class="card-header msg_head" style="background: #00C89E;">
							<div class="d-flex bd-highlight">
								<div class="user_info">
									<span><b>판매자와의 채팅</b></span>
								</div>
								<div class="video_cam">
									<span><i class="fas fa-video" id="videoOn"></i></span>
								</div>
							</div>
							<span id="action_menu_btn" onclick="javascript:removeArea()"><i class="fas fa-times"></i></span>
						</div>
					 	<div class="chatroom">
						<div class="card-body msg_card_body" id="msgDiv">
	                        <div id="msgDiv">
	                            <div id="messages">
	                       
									</div>
								</div>
							</div>
	                    </div>
						<div class="card-footer">
						
                            
							<div class="input-group pf-title">
								   <input style="width:100%;padding-left: 30px;color: #666666;border: 1px solid #e1e1e1;font-size: 14px;" type="text" id="msg" placeholder="메세지 전송" autocomplete="off" onKeyDown="onChatSubmit()">
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/socket.io/2.3.0/socket.io.dev.js"></script>
   
    <script>
    /*  USER  */
    var socket = io.connect('${socketPort}')
    var url = location.href
    var params = url.split('/')
    var requestedRoom = params[4]           //room number 

    var remoteStream
    var remoteVideo = document.getElementById('video')
    var pc;
    var pcConfig = {
        'iceServers': [
            {
                'urls': 'stun:stun.l.google.com:19302'
            }
            ,
            {
                urls: 'turn:numb.viagenie.ca',
                credential: 'muazkh',
                username: 'webrtc@live.com'
            }
        ]
    };

    const constraints = {
        audio: true,
        video: {
        width: 1280, height: 720
        }
    };

    /**************************** 
              User Info
    *****************************/
    var name = '${member.name}'
    var _room = ${requestedRoom}
    var flag;
    console.log(`${member.name}님이 ${requestedRoom}에 접속하였습니다`)


    /**************************** 
                Socket
    *****************************/

    //user 접속 
    socket.emit('user-join', ${requestedRoom}, '${member.name}')

    socket.on('joinedUser', (name, id, numberofClients, roomInfo) => {
        $('#numoof-visitor').text(numberofClients)
        console.log("이름 : " + name);
        console.log("방 ID : " + id);
        console.log("들어온 사람수 : " + numberofClients);
        console.log("방정보 : " + roomInfo);
        //$('#channel-name').text('('+roomInfo.room+')')
        //$('#onair-title').text(roomInfo.title)
    })

    socket.on('roomSetting', (roomInfo) => {
        console.log('정보 세팅하기');
        console.log(roomInfo)
        $('#channel-name').text(roomInfo.caster)
        $('#onair-title').text(roomInfo.title)
    })

    socket.on('message', (msg) => {
        if(msg.type === 'offer'){
            console.log(`(Offer)받은메시지`)
            createPeerConnectionUser()
            pc.setRemoteDescription(new RTCSessionDescription(msg))
            sendAnswer()
        } else if (msg.type === 'candidate') {
            var candidate = new RTCIceCandidate({
                sdpMLineIndex: msg.label,
                candidate: msg.candidate
            })
            pc.addIceCandidate(candidate)
        } else if(msg.type === 'bye'){
            handleRemoteHangup()
        }else{
            console.log(`잘 못 보낸 메세지입니다! ${msg}`)
        }

    })

    //Chat
    socket.on('chat-message', (name, msg) => {
        appendMessage(name, msg)
    })

    socket.on('livedCaster', (room) =>{
        alert('방송이 종료되었습니다')
        location.href='https://localhost:5571/'
        //location.href='http://192.168.10.169:8787/dolduck/live-home.do'
    })



    /**************************** 
        WebRTC - PeerConnection
    *****************************/
    function createPeerConnectionUser(){    
        try{
            pc = new RTCPeerConnection(null)
            pc.onaddstream =  handleRemoteStreamAdded
            pc.onicecandidate = handleIceCandidateUser
            pc.onremovestream = handleRemoteStreamRemoved
            console.log('(User)PeerConnection Created')

        }catch(e){
            console.log('Error in Creating (User)PeerConnection , e: ', e);
            alert('Cannot create RTCPeerConnection object.');
            return;
        }
    }

    function sendAnswer(){
        console.log('Sending answer to Remote Peer ');
        pc.createAnswer()
        .then(setLocalAndSendMessageUser, handleCreateSessionDescriptionError)
    }

    function setLocalAndSendMessageUser(sdp){
        pc.setLocalDescription(sdp)
        console.log('setLocalAndSendMessage : ', sdp)
        sendMessage(sdp)
    }

    function handleCreateSessionDescriptionError(err){
        console.log('Failed to create session descriptioin : ', err.toString())
    }

    function handleRemoteStreamAdded(event) {
        console.log('Remote stream added.');
        remoteStream = event.stream;
        remoteVideo.srcObject = remoteStream;
    }

    function handleIceCandidateUser(event){
        console.log('IceCandidate event : ', event)
        if(event.candidate){
            sendMessage({
                type : 'candidate',
                label : event.candidate.sdpMLineIndex,
                id : event.candidate.sdpMid,
                candidate : event.candidate.candidate
            })
        }else{
            console.log('End of candidate')
        }
        
    }

    function handleRemoteStreamRemoved(event) {
        console.log('Remote stream removed. Event: ', event);
    }

    function hanldeRemoteHangup(id){
        console.log('Session terminated')
        close(id)
        sendByeMessage()
    }

    function close(id){
        alert('방송이 종료되었습니다')
        findPc(id).close()
    }

    function sendMessage(msg){
        console.log(`클라이언트가 보냄 -> ${msg}`)
        socket.emit('userMessage', msg, ${requestedRoom})
    }

    function sendByeMessage(){
        socket.emit('message', 'bye')
    }



    /*******************
        Chatting
    *******************/

    function appendMessage(userName, msg){
    	
    	var today = new Date();  
        
    	var year = today.getFullYear();
        var month = today.getMonth() + 1;  // 월
        var date = today.getDate();  // 날짜
        var day = today.getDay();  // 요일
        var hours = today.getHours(); // 시
        var minutes = today.getMinutes();  // 분
        
	   var _name = userName;
	   var stringa = msg
	   var text;

	   var nowTime = year+'/'+ month + '/' + date + "  "  + hours + ':' + minutes;
      
        var _name = userName;
        var stringa = msg
        var text;
       	if(userName ==='caster') {
       		flag=1;
       	}else {
       		flag=0;
       	}
        if(flag != 0) {
	        text = " <div class='d-flex justify-content-start mb-4'>${testuser}";
	        text += "<div class='msg_cotainer'>"+stringa+"<span class='msg_time'>"+nowTime+"</span></div></div>";
        }else {
      	   text = " <div class='d-flex justify-content-end mb-4'>${testuser}";
     	   text += "<div class='msg_cotainer_send'>"+stringa+"<span class='msg_time'>"+nowTime+"</span></div></div>";
             	
        }
        
        $('#messages').append($(`<li>`).html(text))
        $(".chatroom").scrollTop($("#msgDiv")[0].scrollHeight);
    }
    

    function onChatSubmit(){
        if(event.keyCode == 13){
            event.preventDefault()
            var msg = $('#msg').val().trim();
            if (msg != "" && msg != null) {
            	flag = 1 ;
                socket.emit('chat-message', ${requestedRoom}, name , msg)
            }
            $('#msg').val('');
        }
    }
    </script>
    
    	 <script>  //SCRIPT :: 경매 정보 출력 (기존 정보 삭제)
  	$("#videoOn").click(function(){//클릭한 id의 부모는 tr

  		if($('#videoArea').css('display') === 'none') {
			$("#videoArea").show();
  		} else {
  			$('#videoArea').hide();
  		}
		});
    	 </script>
    	 <script>
	
</script>  
</div>
