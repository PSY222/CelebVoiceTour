# Tour AI Hakathon _ CelebVoiceTour ⭐🔊
## [Service Overview](https://youtu.be/d-fdLNISIXE)
한국관광공사 오디오 해설 API에 음성변환AI를 적용해, 한국을 방문하는 외국인 관광객에게 특별한 관광경험을 선사하는 '내귀에 셀럽'입니다. '내귀에 셀럽'은 최애 K-POP 아이돌의 목소리로 오디오 해설을 듣고, 해당 가수의 음원을 함께 들을 수 있는 플레이리스트를 제공하여 여행에 특별함을 더하는 웹 서비스 입니다.  <br>

Bringing a unique tourism experience to foreign visitors exploring Korea, the 'CelebVoiceTour' utilizes voice conversion AI in the Korea Tourism Organization's audio guide API. With 'CelebVoiceTour', tourists can enjoy audio guides narrated by their favorite K-POP idols, accompanied by playlists featuring the artist's music, adding an extra layer of specialness to their journey.

## 🔨 Tech Stack
<img src="https://img.shields.io/badge/Python-3766AB?style=flat-square&logo=Python&logoColor=white"/></a>
<img src="https://img.shields.io/badge/Java-F7DF1E?style=flat-square&logo=JavaScript&logoColor=white"/></a>
<img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=flat-square&logo=JavaScript&logoColor=white"/></a>
<img src="https://img.shields.io/badge/SQL-A4373A?style=flat-square&logo=Microsoft Access&logoColor=white"/></a>
<img src="https://img.shields.io/badge/HTML-E34F26?style=flat-square&logo=HTML5&logoColor=white"/></a>
<img src="https://img.shields.io/badge/CSS-1572B6?style=flat-square&logo=CSS3&logoColor=white"/></a>
<img src="https://img.shields.io/badge/Pytorch-EE4C2C?style=flat-square&logo=TensorFlow&logoColor=white"/></a>

- IDE: IntelliJ IDEA
- Automation tool: Gradle
- DB System: MySQL
- Web Framework : Spring Boot

## 📌AI Tech
Bark Model : Transformer based text-to-audio model by [Suno AI](https://github.com/suno-ai/bark) <br>
The Bark model consists of three transformer models designed to convert text into audio, with distinct stages of processing. It begins by transforming text into semantic tokens using the BERT tokenizer from Hugging Face. These semantic tokens encode the audio content to be generated. In the subsequent step, the model converts semantic tokens into coarse tokens using the EnCodec Codec's first two codebooks from Facebook. Finally, the process involves transforming the first two codebooks from EnCodec into 8 codebooks, providing finer audio details. ([Hugginface model details](https://huggingface.co/suno/bark))

This service utilized voice cloning based on the incredible work from [Serp-Ai](https://huggingface.co/suno/bark). K-POP celebrity's voice was extracted from YouTube video and adjusted noise using Audacity. I transformed K-POP Celebrity's audio file to semantic token using HuBERT model and tokenizer. Then, I went through numerous experiments of generating custom voice by processing pre-generated voice with target celebrity's npz token.

I shared ['VITS_model_with Whisper tutorial'](https://github.com/PSY222/CelebVoiceTour/blob/main/Tutorial_3_VITS_model_with_Whisper) for anyone who wants to try customized voice cloning using VITS model with Whisper.

Refer to this [article](https://www.linkedin.com/pulse/ai-voice-cloning-bark-hubert-practical-guide-felix-leber%3FtrackingId=gMIlVvyXRR2OfBRzSRU1fg%253D%253D/?trackingId=gMIlVvyXRR2OfBRzSRU1fg%3D%3D) for more step-by-step approach.

