import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:3000"
});

export default {

    getTopics() {
      return http.get('/topics');
    },
    getDetails(topicId) {
        return http.get(`/topics/${topicId}`)
      },

    getMessage(topicId, messageId){
      return http.get(`/topics/${topicId}`).then((response) => {
        const topic = response.data;
        const messages = topic.messages;
        return messages.find(message => message.id == messageId);
      })
    }  
  
  }