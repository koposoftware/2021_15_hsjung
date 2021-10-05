<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <base href="/">
    <title>HanaMarket | Guest View</title>
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
    <!-- 합쳐지고 최소화된 최신 CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <!-- 부가적인 테마 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
    <link href="${pageContext.request.contextPath}/resources/chat/chatting.css" rel="stylesheet" />
    
    <!-- 합쳐지고 최소화된 최신 자바스크립트 -->
</head>
<div class="removeArea">
			<div class="row justify-content-center" style="margin-top: -220px; position:fixed; z-index:3; " class="chatArea">
					<div class="channel-controlbox" style="padding: 4px;display:none">
			                <button id="startButton">START</button>
			                <button id="recButton">REC</button>
			                <button type="button" class="btn btn-secondary" id="stopButton">STOP</button>
			        </div>
			 		<div id="info-title">
                        <span id="onair-title" style="display: none">Live Stream Title on this</span>
                    </div>
                    
				<div class="col-md-6 col-xl-6 chat"  id="videoArea" style="padding: 4px;height : 290px;display:none" id="videoArea">
					<div class="card mb-sm-3 mb-md-0 contacts_card" style="width:2000px;height:285px;" >
							<div class="card-body contacts_body" style="height:300px;background-color:#fff!important;">
						   		<div class="channel-video-area">
			                    	<video class="video" id="localVideo" autoplay controls style="width:400px;margin:15px;"></video>
			                	</div> 
							</div>
					</div>
				</div>
				<div class="col-md-4 col-xl-4 chat">
					<div class="card" style="margin-left: 25px;height: 400px;width: 365px;background-color:#fff!important;" >
						<div class="card-header msg_head" style="background: #00C89E;">
							<div class="d-flex bd-highlight">
								<div class="user_info">
									<span>구매자와의 채팅</span>
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
							<div class="input-group">
								   <b style="margin-top : 10px;">메세지 입력 :</b> 
								   <input type="text" id="msg" autocomplete="off" onKeyDown="onChatSubmit()" style="width: 75%;padding-left: 30px;color: #666666;border: 1px solid #e1e1e1;font-size: 14px;">
								   <b style="margin-top : 10px;"><br>흥정가 입력 :</b> 
								   <input type="text" id="negoPrice" autocomplete="off" style="width:53%;padding-left: 30px;color: #666666;border: 1px solid #e1e1e1;font-size: 14px;">
								   <button type="button" id="nego">판매하기</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/socket.io/2.3.0/socket.io.dev.js"></script>
     <script>
    /**************************** 
    RTC & Peer Info
   *****************************/
   var localStream
   var remoteStream
   var pc
   var pcArr = []
   var pcConfig = {
   'iceServers': [
       { 'urls': 'stun:stun.l.google.com:19302' }
       ,
       {
           urls: 'turn:numb.viagenie.ca',
           credential: 'muazkh',
           username: 'webrtc@live.com'
       }
   ]
   }
   var sdpConstraints = {      
   offerToReceiveAudio: 1,         
   offerToReceiveVideo: 1              // 1 = true    
   };
   
   var video = document.getElementById('localVideo')
   const constraints = {
   audio: true,
   video: { width: 1280, height: 720 }
   };
   
   /**************************** 
         Caster Info
   *****************************/
//   var title = '${member.name}님과의 채팅방'
   var title = ''
   var _room = ${requestedRoom}
   var clients = []
   
   
   /**************************** 
           Socket
   *****************************/
   var socket = io.connect('${socketPort}');
   
   socket.emit('create', '${member.name}', '${member.name}님과의 채팅방',${requestedRoom})
   
   document.getElementById('onair-title').innerHTML = title
   
   socket.on('createdRoom', (roomNumber) =>{
   console.log("this room number is" + ${requestedRoom})
   
   var roomInfo = {
       'room' : ${requestedRoom},
       'caster' : '${member.name}',
       'casterid' : socket.id,
       'title' : '${member.name}님과의 채팅방',
       'thumb' : `https://v-phinf.pstatic.net/20190813_56/1565623602340qwcBD_JPEG/upload_2.jpg?type=f228_128`,
       'date' : getTimeStamp()
   }
   socket.emit('caster-join', roomInfo)
   })
   
   socket.on('joinedUser', (name, id, numberofClients) => {
   var newUser = {
       name : name,
       id : id
   }
   $('#numoof-visitor').text(numberofClients)
   clients.push(newUser)
   console.log(`(New user joined)${newUser.name}님이 접속하였습니다!`);
   casterPeerCreate(newUser.id)
   })
   
   socket.on('message', (message,  id) => {
   console.log('Client received message: ', message)
   if(message.type === 'answer'){
       console.log('Received Answer message')
       commit(findPc(id).setRemoteDescription(new RTCSessionDescription(message)),id)
   }else if(message.type === 'candidate'){
       var candidate = new RTCIceCandidate({
           sdpMLineIndex : message.label,
           candidate : message.candidate
       })
       commit(findPc(id).addIceCandidate(candidate), id)
   }else if(message.type === 'bye'){
       hanldeRemoteHangup()
   }
   })
   
   socket.on('chat-message', (name, msg) => {
   appendMessage(name, msg)
   })
   
   /**************************** 
   WebRTC - PeerConnection
   *****************************/
   
   function findPc(id) {
   for (let i = 0; i < pcArr.length; i++) {
       if (pcArr[i].id === id) {
           return pcArr[i].pc
       }
   }
   }
   
   function commit(pc, id){
   for (let i = 0; i < pcArr.length; i++) {
       if (pcArr[i].id === id) {
           pcArr[i].pc === pc
       }
   }
   }
   
   function casterPeerCreate(id) {
   console.log('피어 커넥션 생성');
   
   
   pcArr.push({ 'id': id, 'pc': createPeerConnection(id) })
   console.log('생성된 피어 : ', findPc(id) );
   commit(findPc(id).addStream(localStream), id)
   sendOffer(id)
   }
   
   function createPeerConnection(id){
   var emptyPc
   try{
       emptyPc = new RTCPeerConnection(null)
       emptyPc.onicecandidate = function(event){
           handleIceCandidateCaster(event, id)
       }
       //emptyPc.onaddStream = handleRemoteStreamAdded
       //emptyPc.onremovestream = handleRemoteStreamRemoved
       console.log('Created RTCPeerConnection')
       return emptyPc
   }catch(e){
       console.log('Failed to create PeerConnection.\nexception : ', e)
       alert('Cannot create RTCPeerConnection object.')
       return;
   }
   }
   
   function sendOffer(id) {
   console.log(`Send Offer to Client(${id})`);
   findPc(id).createOffer()
       .then(function (sessionDescription) {
           setLocalAndSendMessageCaster(sessionDescription, id)
       })
       .catch(function (err) {
           handleCreateOfferError(err)
       })
   }
   
   function setLocalAndSendMessageCaster(sdp, id){
   commit(findPc(id).setLocalDescription(sdp), id)
   console.log('SetLocal And SendMessage sending message : ', sdp)
   sendMessage(sdp, id)
   }
   
   function handleCreateOfferError(err){
   console.log(`Error : ${err}`);
   }
   
   function handleIceCandidateCaster(e, id){
   console.log('icecandidate event: ', e)
   if(e.candidate){
       sendMessage({
           type : 'candidate',
           label : e.candidate.sdpMLineIndex,
           id : e.candidate.sdpMid,
           candidate : e.candidate.candidate
       },id)
   }else{
       console.log('End of candidates.')
   }
   }
   
   function handleRemoteStreamAdded(event){
   console.log('Remote Stream Added')
   remoteStream = event.stream
   remoteVideo.srcObject = remoteStream
   }
   
   function handleRemoteStreamRemoved(event){
   console.log('Remote Stream Removed : ', event);
   }
   
   function hanldeRemoteHangup(id){
   console.log('Session terminated')
   close(id)
   }
   
   function close(id){
   commit(findPc(id).close(), id)
   }
   
   function sendMessage(msg, id){
   console.log(`sendMessage : ${msg} / ${id}`);
   socket.emit('casterMessage', msg, id)
   }
   
   function sendByeMessage(){
   socket.emit('message', 'bye')
   }
   
   
   window.onbeforeunload = function () {
   sendByeMessage()
   };
   
   /** Setting TURN Server **/
   var turnReady
   
   function requestTurn(turnURL){
   var turnExists = false;
   for(var i in pcConfig.iceServers){
       if(pcConfig.iceServers[i].urls.substr(0,5) === 'turn:'){
           turnExists = true;
           turnReady = true;
           break;
       }
   }
   if(!turnExists){
       console.log('Getting TURN server from', turnURL)
   
       var xhr = new XMLHttpRequest()
       xhr.onreadystatechange = function(){
           if(xhr.readyState === 4 && xhr.status === 200){
               var turnServer = JSON.parse(xhr.responseText)
               console.log('Got TURN server: ', turnServer)
               pcConfig.iceServers.push({
                   'urls' : 'turn:' + turnServer.username + '@' + turnServer.turn,
                   'credential' : turnServer.password
               })
               turnReady = true
           }
       }
       xhr.open('GET', turnURL, true)
       xhr.send()
   }
   }
   
   
   /**************************** 
   WebRTC- Recording Video
   *****************************/
   
   //var startBtn = document.getElementById('startButton')
   var stopBtn = document.getElementById('stopButton')
   
   const mediaSource = new MediaSource()
   let mediaRecorder;
   let recordedBlobs = [];
   let sourceBuffer;
   var videoSeq = 0;
   
   function handleSourceopen(e){
   console.log('MediaSource Opened')
   sourceBuffer = mediaSource.addSourceBuffer('video/webm; codecs="vp8"')
   console.log('Source buffer: ', sourceBuffer)
   }
   
   function handleSuccess(stream){
   console.log('getUserMedia() got stream : ', stream)
   localStream = stream
   //window.stream = stream
   video.srcObject = stream
   startRecording()
   }
   
   function handleDataAvailable(event) {
   if (event.data && event.data.size > 0) {
     recordedBlobs.push(event.data);
   }
   }
   
   function startRecording(){
   //Setting Recording Options
   let options = {mimeType: 'video/webm;codecs=vp9'};
   if (!MediaRecorder.isTypeSupported(options.mimeType)) {
     console.error(`${options.mimeType} is not Supported`);
     errorMsgElement.innerHTML = `${options.mimeType} is not Supported`;
     options = {mimeType: 'video/webm;codecs=vp8'};
     if (!MediaRecorder.isTypeSupported(options.mimeType)) {
       console.error(`${options.mimeType} is not Supported`);
       errorMsgElement.innerHTML = `${options.mimeType} is not Supported`;
       options = {mimeType: 'video/webm'};
       if (!MediaRecorder.isTypeSupported(options.mimeType)) {
         console.error(`${options.mimeType} is not Supported`);
         errorMsgElement.innerHTML = `${options.mimeType} is not Supported`;
         options = {mimeType: ''};
       }
     }
   }
   
   try{
       mediaRecorder = new MediaRecorder(localStream, options)
   }catch(e){
       console.log('Error : ', e);
       return ;
   }   
   
   //녹화시작: rec버튼 무효/stop버튼 유효화 
   stopBtn.disabled = false
   //레코딩이 끝나면 저장
   mediaRecorder.onstop = function(e){
       downloadRecording()
       console.log('Recoreded stop : ', e);
   }
   
   //녹화 시작!
   mediaRecorder.ondataavailable = handleDataAvailable;
   mediaRecorder.start(); 
   console.log('MediaRecorder started', mediaRecorder);
   }
   
   function stopRecording(){
   stopBtn.disabled = true
   mediaRecorder.stop()
   console.log('Recorded Blobs: ', recordedBlobs);
   }
   
   function downloadRecording(){
   ++videoSeq;
   //Blob 객체는 파일과 흡사한 불변 객체로 raw data
   const blob = new Blob(recordedBlobs, {type: 'video/webm'});
   const url = window.URL.createObjectURL(blob);
   const a = document.createElement('a');
   a.style.display = 'none';
   a.href = url
   a.download = `dd-live-${name}-${videoSeq}.webm`;
   document.body.appendChild(a);
   a.click();
   setTimeout(() => {
     document.body.removeChild(a);
     window.URL.revokeObjectURL(url);
   }, 100);
   }
   
   
   async function init(constraints){
   try {
       const stream = await navigator.mediaDevices.getUserMedia(constraints);
       handleSuccess(stream);
   } catch (e) {
       console.error('navigator.getUserMedia error:', e)
       alert(`Error occured on getUserMedia() : ${e} `)
   }
   }
   
   //startBtn.addEventListener('click', ()=>{ init(constraints); startBtn.disabled = true; })
   stopBtn.addEventListener('click', ()=>{ stopRecording(); console.log('Stop Recording....')})
   mediaSource.addEventListener('sourceopen', handleSourceopen, false)
   
   /************** 
   Chatting
   ***************/
   
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
      		flag=0;
      	}else {
      		flag=1;
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
           socket.emit('chat-message', ${requestedRoom}, 'caster', msg)
       }
       $('#msg').val('');
   }
   }
   
   $("#nego").click(function(){
	   var negoPrice = $("#negoPrice").val();
	   event.preventDefault()
       var msg = $('#msg').val().trim();
	   var str = "판매자가 제시한 판매 가격 입니다 : " + negoPrice 
	   str += "<h5><a href='${pageContext.request.contextPath}/member/productDetailWithNego?productSq=${postItList.product.productSq}&price="+negoPrice+"' style='display: inline-block;text-overflow: ellipsis;white-space: nowrap;overflow: hidden;width: 100%;'>";
	   str += "${postItList.product.productName} 구매하러 가기</a></h5>";
	   str += "<h5>해당 링크를 통해 할인된 가격에 물건을 구매하세요!!</h5>";
       if (str != "" && str != null) {
           socket.emit('chat-message', ${requestedRoom}, 'caster', str)
       }
       $('#msg').val('');
   });
   function onChatSubmit2(){
	   if(event.keyCode == 13){
	       event.preventDefault()
	       var msg = $('#msg').val().trim();
	       if (msg != "" && msg != null) {
	           socket.emit('chat-message', ${requestedRoom}, 'caster', msg)
	       }
	       $('#msg').val('');
	   }
	   }
   
   
   /*************** 
   Useful Func
   ****************/
   
   function getTimeStamp() {
   var d = new Date();
   var stamp =
     leadingZeros(d.getFullYear(), 4) + '-' +
     leadingZeros(d.getMonth() + 1, 2) + '-' +
     leadingZeros(d.getDate(), 2) + ' ' +
     leadingZeros(d.getHours(), 2) + ':' +
     leadingZeros(d.getMinutes(), 2) + ":00";
   console.log('now is', stamp, ' ...');
   
   return stamp;
   }
   
   function leadingZeros(n, digits) {
   var zero = '';
   n = n.toString();
   
   if (n.length < digits) {
     for (i = 0; i < digits - n.length; i++)
       zero += '0';
   }
   return zero + n;
   }
   
   $(function(){
   init(constraints); 
   //startBtn.disabled = true
   stopBtn.disabled = true
   })
       
    </script>
    
     <script>  //SCRIPT :: 경매 정보 출력 (기존 정보 삭제)
  	$("#videoOn").click(function(){//클릭한 id의 부모는 tr

		$("#videoArea").show();
		});
    	 </script>
    	 
   </div> 
    
