async function doA(){

    console.log("doA.......")

    const response = await axios.get("/replies")
    const data=response.data
    console.log("doA..data",data)
    return data

}

const doB = (fn) => {
    console.log("doB....")
    try {
        axios.get('/replies').then(response => {
            console.log(response)
            const arr = response.data
            fn(arr)
        })
    }catch(error){
        console.log(err)
            }
}

async function doC(obj){

   const response =  await axios.post("/replies",obj)
    return response.data


}

const doD = async(rno) => {
    const response = await axios.delete(`/replies/${rno}`)
    return response.data


}

const doE = async(reply) => {
    const response = await axios.put(`/replies/${reply.rno}`, reply)
    return response.data
}


const getReplyList = async (bno) => {

    const response = await axios.get(`/replies/list/${bno}`)
//보드 앞에 슬래시 중요함!
    return response.data

}





async function addReply(obj){

    const response =  await axios.post("/replies",obj)

    return response.data
//새로 갱신하고 나면 목록 데이터를 다시 가져 올 수 있도록 해야함!

}


const removeReply = async(rno) => {
    const response = await axios.delete(`/replies/${rno}`)
    return response.data

}


const modifyReply = async(reply) =>{
    const response = await axios.put(`/replies/${reply.rno}`, reply)
    return response.data
}

