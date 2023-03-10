<template>
  <div style="width: 300px">
    <el-form :label-position="labelPosition" label-width="80px" :model="formInfo">
      <el-form-item style="visibility: hidden" label="id">
        <el-input v-model="formInfo.userId"></el-input>
      </el-form-item>
      <el-form-item label="姓名">
        <el-input v-model="formInfo.userName"></el-input>
      </el-form-item>
      <el-form-item label="年龄">
        <el-input v-model="formInfo.userAge"></el-input>
      </el-form-item>
      <el-form-item label="邮箱">
        <el-input v-model="formInfo.userEmail"></el-input>
      </el-form-item>
    </el-form>

    <el-button type="primary" @click="add()">添加</el-button>
    <el-button type="primary" @click="update()">修改</el-button>
  </div>
  <hr>
  <div class="table-container">

    <el-table :data="tableData" style="width: 100%">
      <el-table-column fixed prop="userId" label="id" width="150" />
      <el-table-column prop="userName" label="Name" width="120" />
      <el-table-column prop="userAge" label="age" width="120" />
      <el-table-column prop="userEmail" label="email" width="120" />
      <el-table-column fixed="right" label="Operations" width="130">
        <template #default="scope">
          <el-button link type="primary" size="small" @click="tableToForm(scope.row)">修改</el-button>
          <el-button link type="primary" size="small" @click="deleteUser(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>


</template>

<script>
import axios from "axios";

export default {
  name: "UserView",
  methods: {
    tableToForm(row) {
      this.formInfo = row;
      console.log(row)
    },
    add() {
      const _this = this;
      axios.get('http://localhost:8080/User/addUser?', {
        params: {
          userName: _this.formInfo.userName,
          userAge: _this.formInfo.userAge,
          userEmail: _this.formInfo.userEmail
        }
      });
      this.formInfo = ''
    },
    update() {
      const _this = this;
      console.log(_this.formInfo)
      axios.post('http://localhost:8080/User/updateUser', {
          userId: _this.formInfo.userId,
          userName: _this.formInfo.userName,
          userAge: _this.formInfo.userAge,
          userEmail: _this.formInfo.userEmail
      });
      this.formInfo = ''
    },
    deleteUser(row) {
      axios.get('http://localhost:8080/User/deleteUser?id=' + row.userId);
    }
  },
  created() {
    const _this = this;
    axios.get('http://localhost:8080/User/getList').then(function (resp) {
      console.log(resp.data);
      _this.tableData = resp.data;
    })
  },
  data() {
    return {
      tableData: [
        // {
        //   id: '2016-05-03',
        //   name: 'Tom',
        //   age: 'California',
        //   email: 'Los Angeles'
        // }
      ],
      labelPosition: 'right',
      formInfo: {
        userId: '',
        userName: '',
        userAge: '',
        userEmail: ''
      }


    }
  }
}
</script>

<style scoped>
  .table-container {
    width: 650px;
  }
</style>
